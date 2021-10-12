const express = require("express");
const router = express.Router();
const controller=require('../service/service')
router.get('/', controller.index);
router.get("/new",controller.newPage);
router.post("/new", controller.new);
router.get("/show/:id", controller.show);
router.get("/edit/:id", controller.editPage);
router.put("/edit/:id", controller.edit);
router.delete("/delete/:id", controller.delete);
module.exports = router;
