<template>
  <div class="hello">
    课程：
    <template>
      <el-select v-model="courseId" clearable placeholder="请选择">
        <el-option v-for="item in course" :key="item.id" :label="item.name" :value="item.id"></el-option>
      </el-select>
    </template>
    班级：
    <template>
      <el-select v-model="classId" clearable placeholder="请选择">
        <el-option v-for="item in clazz" :key="item.id" :label="item.name" :value="item.id"></el-option>
      </el-select>
    </template>
    讲师：
    <template>
      <el-select v-model="teacherId" clearable placeholder="请选择">
        <el-option v-for="item in teacher" :key="item.id" :label="item.name" :value="item.id"></el-option>
      </el-select>
    </template>
    单元：
    <el-input placeholder="请输入单元内容" v-model="workNo" clearable style="width: 230px;"></el-input>收作业日期：
    <el-date-picker v-model="finishDate" type="date" value-format="yyyy-MM-dd" placeholder="选择日期"></el-date-picker>
    <el-button type="primary" icon="el-icon-search" @click="onSearch">搜索</el-button>
    <el-button type="primary" icon="el-icon-edit" @click="handleSave">添加</el-button>
    <el-table :data="homework" border style="width: 100%">
      <el-table-column prop="courseName" label="课程" width="180"></el-table-column>
      <el-table-column prop="className" label="班级" width="180"></el-table-column>
      <el-table-column prop="teacherName" label="讲师" width="180"></el-table-column>
      <el-table-column prop="workNo" label="单元" width="180"></el-table-column>
      <el-table-column prop="finishDate" label="收作业时间" width="180"></el-table-column>
      <el-table-column prop="workConent" label="收作业内容概要" width="180"></el-table-column>
      <el-table-column prop="studentName" label="学生姓名" width="180"></el-table-column>
      <el-table-column label="作业录屏文件" width="180">
        <template slot-scope="scope">
          <el-link
            v-if="scope.row.submitFile != null"
            :href="'http://localhost:80/'+scope.row.submitFile"
            type="primary"
          >{{scope.row.studentName}}作业.mp4</el-link>
        </template>
      </el-table-column>
      <el-table-column prop="workName" label="作业完成状态" width="180"></el-table-column>
      <el-table-column label="操作">
        <template slot-scope="scope">
          <el-button size="mini" @click="handleEdit(scope.$index, scope.row)">提交作业</el-button>
          <el-button size="mini" @click="handleComment(scope.$index, scope.row)">作业点评</el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-pagination
      :page-size="pageSize"
      :pager-count="11"
      layout="prev, pager, next"
      :total="total"
      @current-change="currentChange"
    ></el-pagination>
  </div>
</template>

<script>
import axios from "../api/common";
export default {
  name: "HelloWorld",
  data() {
    return {
      homework: [],
      pageSize: 5,
      total: 0,
      courseId: "",
      course: [],
      classId: "",
      clazz: [],
      teacherId: "",
      teacher: [],
      workNo: "",
      finishDate: ""
    };
  },
  methods: {
    getHomework(pageNum) {
      var search = {
        params: {
          pageNum: pageNum,
          courseId: this.courseId,
          classId: this.classId,
          teacherId: this.teacherId,
          workNo: this.workNo,
          finishDate: this.finishDate
        }
      };
      axios.get("/homework", search).then(res => {
        this.homework = res.data.list;
        this.total = res.data.total;
        this.pageSize = res.data.pageSize;
      });
    },
    currentChange(pageNum) {
      this.getHomework(pageNum);
    },
    getCourse() {
      axios.get("/course").then(res => {
        this.course = res.data;
      });
    },
    getClazz() {
      axios.get("/clazz").then(res => {
        this.clazz = res.data;
      });
    },
    getTeacher() {
      axios.get("/teacher").then(res => {
        this.teacher = res.data;
      });
    },
    onSearch() {
      this.getHomework();
    },
    handleEdit(index, row) {
      this.$router.push({ name: "HomeworkAdd", params: row });
    },
    handleSave() {
      this.$router.push("/homeworksave");
    },
    handleComment(index, row){
      this.$router.push({name:"Comment", params: row})
    }
  },
  mounted() {
    this.getHomework();
    this.getCourse();
    this.getClazz();
    this.getTeacher();
  }
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h1,
h2 {
  font-weight: normal;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
