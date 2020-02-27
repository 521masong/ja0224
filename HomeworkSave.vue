<template>
  <div class="hello">
    <el-form ref="form" :model="homework" label-width="100px">
      <el-form-item label="课程">
        <template>
          <el-select v-model="courseId" clearable placeholder="请选择">
            <el-option
              v-for="item in course"
              :key="item.id"
              :label="item.name"
              :value="item.id">
            </el-option>
          </el-select>
        </template>
      </el-form-item>
      <el-form-item label="班级">
        <template>
          <el-select v-model="classId" clearable placeholder="请选择">
            <el-option
              v-for="item in clazz"
              :key="item.id"
              :label="item.name"
              :value="item.id">
            </el-option>
          </el-select>
        </template>
      </el-form-item>
      <el-form-item label="讲师">
        <template>
          <el-select v-model="teacherId" clearable placeholder="请选择">
            <el-option
              v-for="item in teacher"
              :key="item.id"
              :label="item.name"
              :value="item.id">
            </el-option>
          </el-select>
        </template>
      </el-form-item>
      <el-form-item label="单元">
        <el-input
          placeholder="请输入单元内容"
          v-model="homework.workNo"
          clearable
          style="width: 230px;">
        </el-input>
      </el-form-item>
      <el-form-item label="收作业日期">
        <el-date-picker
          v-model="homework.finishDate"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="选择日期">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="作业内容">
        <el-input type="textarea" v-model="homework.workConent" style="width: 330px"></el-input>
      </el-form-item>
      <el-form-item label="图例">
        <el-upload
          class="upload-demo"
          action="http://localhost:8090/upload"
          multiple
          :on-success="onSuccess">
          <el-button size="small" type="primary">点击上传</el-button>
          <div slot="tip" class="el-upload__tip">只能上传jpg/png文件，且不超过500kb</div>
        </el-upload>
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
  name: 'HelloWorld',
  data () {
    return {
      homework:{},
      courseId:"",
      course:[],
      classId:"",
      clazz:[],
      teacherId:"",
      teacher:[],
      workNo:"",
      printUrl:""
    }
  },
  methods: {
    getCourse() {
      axios.get("/course").then(res => {
        this.course = res.data;
      })
    },
    getClazz() {
      axios.get("/clazz").then(res => {
        this.clazz = res.data;
      })
    },
    getTeacher() {
      axios.get("/teacher").then(res => {
        this.teacher = res.data;
      })
    },
    onSubmit(){
      this.homework.courseId = this.courseId;
      this.homework.classId = this.classId;
      this.homework.teacherId = this.teacherId;
      axios.post("/homeworksave",this.homework).then(res=>{
        this.$router.push("/homework")
      })
    },
    onSuccess(response){
      this.homework.printUrl = response;
    }
  },
  mounted() {
    this.getCourse();
    this.getClazz();
    this.getTeacher();
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h1, h2 {
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
