const router = require('express').Router();
const { achievement } = require('../controllers');

router.get('/findAllOrderBy', achievement.getDataAchievement);

router.post('/post', achievement.addDataAchievement);

// POST localhost:8080/activity/2 => Edit data Achievement
router.put('/update', achievement.editDataAchievement);

// POST localhost:8080/activity/delete => Delete data Achievement
router.delete('/delete', achievement.deleteDataAchievement);

module.exports = router;