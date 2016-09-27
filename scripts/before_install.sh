echo 'killing existing Django process if any'
kill $(ps auxw | grep runserver)
