<template>
  <div class="main-page">
    <div class="title">
      <img class src="../../assets/logo-pc.png">
    </div>
    <div class="title">海外邦个人定制</div>
    <div class="page-part">
      <div class="picker">
        <div class="label">移民目的</div>
        <mt-picker :slots="slots" value-key="name" :visibleItemCount="3" @change="onValuesChange"></mt-picker>
      </div>
      <mt-field label="您的姓名" placeholder="请输入您的姓名" v-model="username" :attr="{ maxlength: 10 }"></mt-field>
      <mt-field
        label="您的电话"
        placeholder="请输入您的电话"
        v-model="phone"
        :attr="{ maxlength: 15 }"
        type="tel"
      ></mt-field>
      <mt-button type="primary" size="large" @click="handleButtonClick">提交</mt-button>
    </div>
  </div>
</template>

<script>
import { addTable, getStaticReourcePath } from '../../api/api';
import util from '../../common/js/util';
import { Toast } from 'mint-ui';


export default {
  data () {
    return {
      localHost: '',
      url: '',

      username: '',
      phone: '',
      purpose: 0,

      slots: [{
        flex: 1,
        values: [{ value: "0", name: "全部" },
        { value: "1", name: "子女教育" },
        { value: "2", name: "养老福利" },
        { value: "3", name: "资产配置" },
        { value: "4", name: "海外医疗" },
        { value: "5", name: "海外置业" },
        { value: "6", name: "出入境方便" }],
        defaultIndex: 1,
        className: 'slot1',
        textAlign: 'center'
      }
      ],
    }
  },
  methods: {

    onValuesChange: function (picker, values) {
      if (values.length > 0) {
        this.purpose = values[0].value;
      }
    },

    handleButtonClick: function (event) {
      if (this.username.length <= 1) {
        Toast({
          message: '请输入您的姓名',
          iconClass: 'mintui mintui-success',
          duration: 3000
        });
        return;
      }
      if (this.phone.length <= 10) {
        Toast({
          message: '请输入您的电话',
          iconClass: 'mintui mintui-success',
          duration: 3000
        });
        return;
      }
      addTable({
        path: 'custom',
        purpose: this.purpose,
        username: this.username,
        phone: this.phone,
        isContact: 0
      }).then((res) => {
        this.$messagebox({
          title: '预约成功',
          message: '您好！恭喜您预约成功，我们会尽快安排专业移民顾问和您联系；提供1对1的专家服务',
          showCancelButton: false,
          confirmButtonText: "确定"
        }).then(action => {
          if (action == 'confirm') {
            this.username = '';
            this.phone = '';
          }
        });
      }).catch(function (error) {

      });
    }

  },
  created () { // 组件初始化时期请求数据
    this.localHost = getStaticReourcePath();

  }
}
</script>

<style>
.main-page {
  background-color: #eee;
  padding-bottom: 50px;
}

.title {
  text-align: center;
  font-size: 1.2em;
  color: brown;
  font-weight: bold;
}

.picker {
  background-color: white;
  margin-top: 20px;
}

.label {
  font-size: 16px;
  line-height: 1;
  min-height: inherit;
  overflow: hidden;
  padding: 10px 10px;
}
</style>