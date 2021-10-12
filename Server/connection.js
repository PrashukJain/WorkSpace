var mysql = require('mysql')
var connection = mysql.createConnection({
  host: 'localhost',
  user: 'root',
  password: 'root',
  database: 'datastorage'
})

connection.connect()

connection.query('Select  * from employee_entity AS solution', function (err, rows, fields) {
  if (err) throw err

  console.log('The solution is: ', solution)
})

connection.end()