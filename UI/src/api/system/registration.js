import request from '@/utils/request'

// 查询指标结果记录列表
export function listRegistration(query) {
  return request({
    url: '/system/registration/list',
    method: 'get',
    params: query
  })
}

// 查询指标结果记录详细
export function getRegistration(coalNumber) {
  return request({
    url: '/system/registration/' + coalNumber,
    method: 'get'
  })
}

// 新增指标结果记录
export function addRegistration(data) {
  return request({
    url: '/system/registration',
    method: 'post',
    data: data
  })
}

// 修改指标结果记录
export function updateRegistration(data) {
  return request({
    url: '/system/registration',
    method: 'put',
    data: data
  })
}

// 删除指标结果记录
export function delRegistration(coalNumber) {
  return request({
    url: '/system/registration/' + coalNumber,
    method: 'delete'
  })
}
