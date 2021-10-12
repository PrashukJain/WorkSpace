const express = require("express");
const app = express();
const mysql = require("mysql");
// const db = mysql.createPool({
//   host: "localhost",
//   user: "root",
//   password: "root",
//   database: "datastorage",
// });
const db = mysql.createConnection({
  host: "localhost",
  user: "root",
  password: "root",
  database: "datastorage",
});
//   connection.connect(function(err) {
//     if (err) {
//       console.error('error connecting: ' + err.stack);
//       return;
//     }

//     console.log('connected as id ' + connection.threadId);
//   });

const port = 3001;
app.get("/", (req, res) => {
  const query1 =
    "Insert into blogs(title,category,content) values ('Ajay','Meerut','bsaraut');";
  db.query(query1, (err, result) => {
    if (err) {
      res.status("error", err);
    } else {
      res.send("heeo");
    }
  });
});
// app.get("/", (req, res) => {
//   console.log("hello");
//   const query1 = "Insert into blogs(title,category,content) values ?,?,?);";
//   db.query(query1, ["help", "category", "content"], (err, result) => {
//     if (err) {
//       res.status("error", err);
//     } else {
//       res.send("heeo");
//     }
//   });
// });
app.listen(port, () => {
  console.log(`http://localhost:${port}`);
});
