const db = require("../models");
const { post } = require("../routes/routes");
//get all blogs
exports.index = (req, res) => {
  db.table.findAll({where:{
 
  }
}).then((result) => {
    res.render("index.ejs", { blogs: result });
  });
  // db.query(`Select * from blogs`, (err, blogpost) => {
  //     if (err) {
  //       console.log(err);
  //     } else {
  //       res.render("index.ejs", { blogs: blogpost });
  //     }
  //   });
};
//new blog page
exports.newPage = (req, res) => {
  res.render("new");
};
// add new blog
exports.new = (req, res) => {
  const Post = req.body;
  db.table
    .create({
      title: Post.title,
      category: Post.category,
      content: Post.content,
    })
    .then(() => {
      res.redirect("/");
    });
  // var d = new Date();
  // db.query(
  //   `INSERT INTO blogs ( title, category, content, createdAt) VALUES ( ${sqlString.escape(
  //     Post.title
  //   )}, ${sqlString.escape(Post.category)}, ${sqlString.escape(
  //     Post.content
  //   )}, ${sqlString.escape(d)})`,
  //   (err, result) => {
  //     if (err) {
  //       console.log(err);
  //     } else {
  //       res.redirect("/");
  //     }
  //   }
  // );
};
//show blogs
exports.show = (req, res) => {
  const id = req.params.id;
  db.query(`Select * from blogs where blogs.id=${id}`, (err, blog) => {
    if (err) {
      console.log(err);
    } else {
      if (blog == null || blog.length == 0) res.redirect("/");
      else res.render("show.ejs", { blog: blog[0] });
    }
  });
};

exports.editPage = (req, res) => {
  const id = req.params.id;
  db.query(`Select * from blogs where blogs.id=${id}`, (err, blog) => {
    if (err) {
      console.log(err);
    } else {
      if (blog == null || blog.length == 0) res.redirect("/");
      else {
        res.render("edit.ejs", { blog: blog[0] });
      }
    }
  });
};

exports.edit = (req, res) => {
  const Post = req.body;
  const id = req.params.id;
  db.query(
    `Update blogs set title=${sqlString.escape(Post.title)},
    category=${sqlString.escape(Post.category)},
    content=${sqlString.escape(Post.content)} where id=${id}`,
    (err, result) => {
      if (err) {
        console.log(err);
      } else {
        res.redirect("/");
      }
    }
  );
};
exports.delete = (req, res) => {
  const id = req.params.id;
  db.query(`Delete from blogs where id=${id}`, (err, result) => {
    if (err) {
      console.log(err);
    } else {
      res.redirect("/");
    }
  });
};
