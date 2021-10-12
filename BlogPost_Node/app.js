const express = require("express");
const app = express();
const router = require("./routes/routes");
const bodyParser = require("body-parser");
const method = require("method-override");
const db = require("./models");

app.set("view engine", "ejs");
app.use(bodyParser.urlencoded({ extended: false }));
app.use(method("_method"));
app.use("/", router);
db.sequelize.sync().then(() => {
  app.listen(5000, () => {
    console.log("server started");
  });
});
