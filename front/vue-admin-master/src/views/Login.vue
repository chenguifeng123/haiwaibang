<template>
  <div class="full-container">
    <el-form
      :model="ruleForm2"
      :rules="rules2"
      ref="ruleForm2"
      label-position="left"
      label-width="0px"
      class="demo-ruleForm login-container"
    >
      <h3 class="title">海外邦后台管理系统</h3>
      <el-form-item prop="account">
        <el-input type="text" v-model="ruleForm2.account" autocomplete="off" placeholder="账号"></el-input>
      </el-form-item>
      <el-form-item prop="checkPass">
        <el-input type="password" v-model="ruleForm2.checkPass" autocomplete="off" placeholder="密码"></el-input>
      </el-form-item>
      <el-checkbox v-model="checked" checked class="remember">记住密码</el-checkbox>
      <el-form-item style="width:100%;">
        <el-button
          type="primary"
          style="width:100%;"
          @click.native.prevent="handleSubmit2"
          :loading="logining"
        >登录</el-button>
        <!--<el-button @click.native.prevent="handleReset2">重置</el-button>-->
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import { requestLogin } from '../api/api';
import { error } from 'util';

//import NProgress from 'nprogress'
export default {
  data () {
    return {
      logining: false,
      ruleForm2: {
        account: 'admin',
        checkPass: 'admin'
      },
      rules2: {
        account: [
          { required: true, message: '请输入账号', trigger: 'blur' },
          //{ validator: validaePass }
        ],
        checkPass: [
          { required: true, message: '请输入密码', trigger: 'blur' },
          //{ validator: validaePass2 }
        ]
      },
      checked: true
    };
  },
  methods: {
    handleReset2 () {
      this.$refs.ruleForm2.resetFields();
    },
    handleSubmit2 (ev) {
      var _this = this;
      const self = this;
      this.$refs.ruleForm2.validate((valid) => {
        if (valid) {
          //_this.$router.replace('/table');
          this.logining = true;
          var loginParams = { username: this.ruleForm2.account, password: this.ruleForm2.checkPass };
          const params = new URLSearchParams();
          params.append('username', this.ruleForm2.account);
          params.append('password', this.ruleForm2.checkPass);
          requestLogin(params).then(res => {
            this.logining = false;
            let data = res.data;
            /*
            let { msg, code } = data;
            if (code !== '00000000') {
              this.$message({
                message: msg,
                type: 'error'
              });
            } else {
              var user = Object.assign({}, loginParams);
              user['avatar'] = 'static/user.png';
              user['name'] = user.username;
              sessionStorage.setItem('user', JSON.stringify(user));
              this.$router.push({ path: '/country' });
            }
            */
            var user = Object.assign({}, loginParams);
            user['avatar'] = 'static/user.png';
            user['name'] = user.username;
            sessionStorage.setItem('user', JSON.stringify(user));
            this.$router.push({ path: '/country' });
          }).catch((error) => {
            this.logining = false;
            this.$message({
              message: '登陆失败',
              type: 'error'
            });
            console.log(error);
          });
        } else {
          console.log('error submit!!');
          return false;
        }
      });
    }
  }
}

</script>

<style lang="scss" scoped>
.full-container {
  position: relative;
  height: 100vh;
  overflow: hidden;
  background: url(../assets/login-back.jpg) no-repeat;
  background-size: 100% 100%;
}

.login-container {
  /*box-shadow: 0 0px 8px 0 rgba(0, 0, 0, 0.06), 0 1px 0px 0 rgba(0, 0, 0, 0.02);*/
  -webkit-border-radius: 5px;
  border-radius: 5px;
  -moz-border-radius: 5px;
  background-clip: padding-box;
  margin: 180px auto;
  width: 350px;
  padding: 35px 35px 15px 35px;
  background: #fff;
  border: 1px solid #eaeaea;
  box-shadow: 0 0 25px #cac6c6;
  .title {
    margin: 0px auto 40px auto;
    text-align: center;
    color: #505458;
  }
  .remember {
    margin: 0px 0px 35px 0px;
  }
}
</style>