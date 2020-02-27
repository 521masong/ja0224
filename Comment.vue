<template>
  <div class="hello">
    <el-form ref="form" :model="studentWork" label-width="120px">
      <el-form-item label="课程">
        <template>
          <el-select v-model="courseId" clearable placeholder="请选择" disabled>
            <el-option v-for="item in course" :key="item.id" :label="item.name" :value="item.id"></el-option>
          </el-select>
        </template>
      </el-form-item>
      <el-form-item label="班级">
        <template>
          <el-select v-model="classId" clearable placeholder="请选择" disabled>
            <el-option v-for="item in clazz" :key="item.id" :label="item.name" :value="item.id"></el-option>
          </el-select>
        </template>
      </el-form-item>
      <el-form-item label="讲师">
        <template>
          <el-select v-model="teacherId" clearable placeholder="请选择" disabled>
            <el-option v-for="item in teacher" :key="item.id" :label="item.name" :value="item.id"></el-option>
          </el-select>
        </template>
      </el-form-item>
      <el-form-item label="单元">
        <el-input placeholder="请输入单元内容" v-model="workNo" clearable style="width: 230px;" disabled></el-input>
      </el-form-item>
      <el-form-item label="学生">
        <template>
          <el-select v-model="studentId" clearable placeholder="请选择" disabled>
            <el-option v-for="item in student" :key="item.id" :label="item.name" :value="item.id"></el-option>
          </el-select>
        </template>
      </el-form-item>
      <el-form-item label="作业内容">
        <el-input type="textarea" v-model="studentWork.workConent" style="width: 280px;" disabled></el-input>
      </el-form-item>
      <el-form-item label="作业附件">
        <el-image
          style="width: 100px; height: 100px"
          :src="'http://localhost:80/' + studentWork.printUrl"
          :preview-src-list="srcList"
        ></el-image>
      </el-form-item>
      <el-form-item label="学生作业视屏">
        <el-link
          v-if="studentWork.submitFile != null"
          :href="'http://localhost:80/'+studentWork.submitFile"
          type="primary"
        >{{studentWork.studentName}}作业.mp4</el-link>
      </el-form-item>
      <el-form-item label="老师评论">
        <el-input type="textarea" :rows="5" placeholder="请输入内容" v-model="studentWork.commentName"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit">立即创建</el-button>
        <el-button>取消</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import axios from "../api/common";
export default {
  name: "HelloWorld",
  data() {
    return {
      studentWork: {},
      courseId: "",
      course: [],
      classId: "",
      clazz: [],
      teacherId: "",
      teacher: [],
      workNo: "",
      studentId: "",
      student: [],
      srcList: []
    };
  },
  methods: {
    getHomework(id) {
      axios.get("/commenthomeworkbyid", { params: { id: id } }).then(res => {
        console.log(res.data);
        this.studentWork = res.data;
        this.studentWork.workId = res.data.id;
        this.courseId = res.data.courseId;
        this.classId = res.data.classId;
        this.teacherId = res.data.teacherId;
        this.studentId = res.data.studentId;
        this.workNo = res.data.workNo;
        this.srcList["http://localhost:80/" + studentWork.printUrl];
      });
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
    getStudent() {
      axios.get("/student").then(res => {
        this.student = res.data;
      });
    },
    onSuccess(response) {
      this.studentWork.submitFile = response;
      console.log(response);
    },
    onSubmit() {
      this.studentWork.stuId = this.studentId;
      axios.post("/comment", this.studentWork).then(res => {
        this.$router.push("/homework");
      });
    }
  },
  mounted() {
    if (this.$route.params) {
      this.getHomework(this.$route.params.id);
    }
    this.getCourse();
    this.getClazz();
    this.getTeacher();
    this.getStudent();
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
