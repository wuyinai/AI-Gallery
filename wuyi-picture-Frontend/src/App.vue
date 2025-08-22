<template>
  <div>
    <BasicLayout />
  </div>
</template>
<script setup lang="ts">
import BasicLayout from '@/layouts/BasicLayout.vue'
import { useLoginUserStore } from '@/stores/userLoginUserStore'

const loginUserStore = useLoginUserStore()
loginUserStore.fetchLoginUser()
</script>
<style scoped></style>
