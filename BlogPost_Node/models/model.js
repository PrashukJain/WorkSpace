module.exports = (sequelize, DataTypes) => {
  const table = sequelize.define("table", {
    id: {
      type: DataTypes.INTEGER,
      autoIncrement: true,
      primaryKey: true,
    },
    title: {
      type: DataTypes.STRING(),
      allowNull: false,
    },
    categories: {
      type: DataTypes.STRING,
    },
    content: {
      type: DataTypes.STRING(1234),
      allowNull: false,
    },
  });
  return table;
};
