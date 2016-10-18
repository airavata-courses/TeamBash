
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.core.KeywordAnalyzer;
import org.apache.lucene.analysis.core.SimpleAnalyzer;
import org.apache.lucene.analysis.core.StopAnalyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.analysis.tokenattributes.OffsetAttribute;
import org.apache.lucene.analysis.tokenattributes.PositionIncrementAttribute;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.Field.Store;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.IndexWriterConfig.OpenMode;
import org.apache.lucene.index.MultiFields;
import org.apache.lucene.index.Term;
import org.apache.lucene.index.Terms;
import org.apache.lucene.index.TermsEnum;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.store.LockObtainFailedException;
import org.apache.lucene.store.RAMDirectory;
import org.apache.lucene.util.BytesRef;
import org.apache.lucene.util.PagedBytes.Reader;
import org.apache.lucene.util.Version;
import org.apache.xerces.parsers.XMLParser;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Paths;

import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;

public class generateIndex {

    private static String corpusPath = "/Users/vimalendu/info_ret/corpus";
    private static String indexPath = "/Users/vimalendu/info_ret/indexGeneration";

    private static String readFile(String file) throws IOException {
        FileReader fileReader = new FileReader(corpusPath + "/" + file);
        BufferedReader reader = new BufferedReader(fileReader);
        String line = null;
        StringBuilder stringBuilder = new StringBuilder();
        String ls = System.getProperty("line.separator");

        while ((line = reader.readLine()) != null) {
            stringBuilder.append(line);
            stringBuilder.append(ls);
        }

        return stringBuilder.toString();
    }

    public static String extract(StringBuilder buf, String startTag, String endTag) {
        String stringBetweenTags = new String();
        int k1 = buf.indexOf(startTag);
        while (k1 >= 0) {
            k1 += startTag.length();
            int k2 = buf.indexOf(endTag, k1);

            if (k2 >= 0) {
                stringBetweenTags += (" " + buf.substring(k1, k2).trim());
            }

            k1 = buf.indexOf(startTag, k2);
        }
        return stringBetweenTags;
    }

    public static void main(String args[]) throws CorruptIndexException, LockObtainFailedException, IOException {
        File docDir = new File(corpusPath);
        Directory dir = FSDirectory.open(Paths.get(indexPath));
        Analyzer analyzer = new StandardAnalyzer();
        IndexWriterConfig iwc = new IndexWriterConfig(analyzer);
        iwc.setOpenMode(OpenMode.CREATE);
        IndexWriter writer = new IndexWriter(dir, iwc);

        try {
            DocumentBuilderFactory dFact = DocumentBuilderFactory.newInstance();
            DocumentBuilder build = dFact.newDocumentBuilder();

            for (File f : docDir.listFiles()) {

                String fileName = f.getName();
                String readBuffer = readFile(fileName);
                StringBuilder builder = new StringBuilder(readBuffer);

                String startDocTag = "<DOC>";
                String endDocTag = "</DOC>";
                int docStart = builder.indexOf(startDocTag);
                while (docStart != -1) {
                    docStart += startDocTag.length();
                    int docEnd = builder.indexOf(endDocTag, docStart);

                    if (docEnd > 0) {
                        StringBuilder document = new StringBuilder(builder.substring(docStart, docEnd).trim());
                        Document doc = new Document();
                        String docno = extract(document, "<DOCNO>", "</DOCNO>");

                        doc.add(new StringField("DOCNO", docno, Field.Store.YES));
                        String head = extract(document, "<HEAD>", "</HEAD>");

                        doc.add(new StringField("HEAD", head, Field.Store.YES));
                        String byline = extract(document, "<BYLINE>", "</BYLINE>");
                        doc.add(new StringField("BYLINE", byline, Field.Store.YES));
                        String dateline = extract(document, "<DATELINE>", "</DATELINE>");
                        doc.add(new StringField("DATELINE", dateline, Field.Store.YES));
                        String text = extract(document, "<TEXT>", "</TEXT>");

                        doc.add(new TextField("TEXT", text, Field.Store.YES));
                        writer.addDocument(doc);
                    }

                    docStart = builder.indexOf(startDocTag, docEnd);
                }
            }
            writer.forceMerge(1);
            writer.commit();
            writer.close();

            IndexReader reader = DirectoryReader.open(FSDirectory.open(Paths.get(
                    (indexPath))));
            //Print the total number of documents in the corpus
            System.out.println("Total number of documents in the corpus:"+reader.maxDoc());
            //Print the number of documents containing the term "new" in <field>TEXT</field>.
            System.out.println("Number of documents containing the term \"new\" for field \"TEXT\": "+reader.docFreq(new Term("TEXT", "new")));
            //Print the total number of occurrences of the term "new" across all documents for <field>TEXT</field>.
            System.out.println("Number of occurrences of \"new\" in the field \"TEXT\": "+reader.totalTermFreq(new Term("TEXT","new")));
            Terms vocabulary = MultiFields.getTerms(reader, "TEXT");
            //Print the size of the vocabulary for <field>TEXT</field>, applicable when the index has only one segment.
            System.out.println("Size of the vocabulary for this field:"+vocabulary.size());
            //Print the total number of documents that have at least one term for <field>TEXT</field>
            System.out.println("Number of documents that have at least one term for this field: "+vocabulary.getDocCount());
            //Print the total number of tokens for <field>TEXT</field>
            System.out.println("Number of tokens for this field:"+vocabulary.getSumTotalTermFreq());
            //Print the total number of postings for <field>TEXT</field>
            System.out.println("Number of postings for this field:"+vocabulary.getSumDocFreq());
            //Print the vocabulary for <field>TEXT</field>
            TermsEnum iterator = vocabulary.iterator();
            BytesRef byteRef = null;
            System.out.println("\n*******Vocabulary-Start**********");
            while((byteRef = iterator.next()) != null) {
                String term = byteRef.utf8ToString();
                System.out.print(term+"\t");
            }
            System.out.println("\n*******Vocabulary-End**********");
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
