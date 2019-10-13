<template>
  <section>
    <el-col :span="24">
      <div>
        <el-form :model="editForm" label-width="100px" :rules="editFormRules" ref="editForm">
          <el-form-item label="发布类型" prop="type">
            <el-select v-model="editForm.type" placeholder="请选择发布类型">
              <el-option
                v-for="item in options"
                :key="item.value"
                :label="item.label"
                :value="item.value"
              ></el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="文章ID" prop="id" v-show="false">
            <el-input v-model="editForm.id" :disabled="true"></el-input>
          </el-form-item>
          <el-form-item label="标题" prop="title">
            <el-input v-model="editForm.title"></el-input>
          </el-form-item>
          <el-form-item label="作者" prop="author">
            <el-input v-model="editForm.author"></el-input>
          </el-form-item>
        </el-form>

        <UEditor :config="config" ref="ueditor"></UEditor>
      </div>
    </el-col>
    <el-col :span="24">
      <el-button type="primary" @click.native="submit" :loading="editLoading">提交</el-button>
    </el-col>
  </section>
</template>

<script>
import UEditor from '@/components/ueditor/ueditor.vue'
import util from '../../common/js/util';
import { addTable } from '../../api/api';

export default {
  name: 'hello',
  components: { UEditor },
  data () {
    return {
      config: {
        autoHeightEnabled: false,
        autoFloatEnabled: true,
        initialContent: '请输入内容',   //初始化编辑器的内容,也可以通过textarea/script给值，看官网例子
        autoClearinitialContent: true, //是否自动清除编辑器初始内容，注意：如果focus属性设置为true,这个也为真，那么编辑器一上来就会触发导致初始化的内容看不到了
        initialFrameWidth: null,
        initialFrameHeight: 450,
        BaseUrl: '',
        UEDITOR_HOME_URL: 'static/ueditor/'
      },

      options: [
        { label: "文章", value: "article" },
        { label: "案例", value: "example" },
        { label: "活动", value: "campaign" }],

      editForm: {
        id: 0,
        title: '',
        author: '',
        contents: '',
        type: 'article',
      },

      editFormRules: {
        type: [
          { required: true, message: '请输入发布类型', trigger: 'blur' }
        ],
        title: [
          { required: true, message: '请输入标题', trigger: 'blur' }
        ],
        author: [
          { required: true, message: '请输入作者', trigger: 'blur' }
        ]
      },
      editLoading: false,
    }
  },
  methods: {
    getParams () {
      // 取到路由带过来的参数 
      let routerParams = this.$route.params.dataobj
      // 将数据放在当前组件的数据内
      console.log(routerParams);
    },

    //获取文档内容
    getContent: function () {
      let content = this.$refs.ueditor.getUEContent();
      return content;
    },
    setContent: function (data) {
      this.$refs.ueditor.setUEContent(data);
    },

    submit: function () {
      this.$confirm('确认提交吗？', '提示', {}).then(() => {
        let para = Object.assign({}, this.editForm);
        para['contents'] = this.getContent();
        util.fillPath(para, this.editForm.type);
        addTable(para).then((res) => {
          var result = res.data;
          this.editLoading = false;
          if (result.code == '00000000') {
            this.$message({
              message: '提交成功',
              type: 'success'
            });
            this.$refs['editForm'].resetFields();
            this.setContent('');
          } else {
            this.$message({
              message: result.msg,
              type: 'success'
            });
          }

        }).catch(function (error) {
          this.addLoading = false;
          this.$message({
            message: '提交失败',
            type: 'error'
          });
          console.log(error);
        });
      });
    },


  },
  created () {
    //this.id = this.$route.params.id;
    if (!!this.$route.query && !!this.$route.query.type) {
      var type = this.$route.query.type;
      this.editForm.type = type;
    }
  }
}

</script>
