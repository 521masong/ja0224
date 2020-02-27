import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import VueQuillEditor from 'vue-quill-editor'
import 'quill/dist/quill.core.css'
import 'quill/dist/quill.snow.css'
import 'quill/dist/quill.bubble.css'
import Homework from "@/components/Homework";
import HomewrokAdd from "@/components/HomewrokAdd";
import HomeworkSave from "@/components/HomeworkSave";
import Comment from "@/components/Comment";
Vue.use(ElementUI)
Vue.use(VueQuillEditor)
export default new Router({
  mode:'history',
  routes: [
    {
      path: '/',
      name: 'HelloWorld',
      component: HelloWorld
    },
    {
      path: '/',
      name: 'HelloWorld',
      component: HelloWorld
    },
    {
      path: '/homework',
      name: 'Homework',
      component: Homework
    },
    {
      path: '/homeworkadd',
      name: 'HomeworkAdd',
      component: HomewrokAdd
    },
    {
      path: '/homeworksave',
      name: 'HomeworkSave',
      component: HomeworkSave
    },


  ]
})
