const mysql = require("mysql");

const db = mysql.createConnection({
  host: "localhost",
  user: "root",
  password: "root",
  database: "datastorage",
});
db.connect((err) => {
  if (!err) {
    db.query("Select 1 from blogs", (err, result) => {
      if (err) {
        db.query(`create table if not exists blogs(
        id int primary key auto_increment,
        title varchar(255)not null,
        category varchar(255)not null,
        content varchar(2000)not null,
        createdAt Date not null
    )`);
      }
    });
  } else {
    console.log("failed to connect");
  }
});
module.exports = db;
