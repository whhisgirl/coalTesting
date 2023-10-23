import request from '@/utils/request'

// 查询【请填写功能名称】列表
export function listRegistration(query) {
  return request({
    url: '/system/registration/list',
    method: 'get',
    params: query
  })
}

// 查询【请填写功能名称】详细
export function getRegistration(coalNumber) {
  return request({
    url: '/system/registration/' + coalNumber,
    method: 'get'
  })
}

// 新增【请填写功能名称】
export function addRegistration(data) {
  return request({
    url: '/system/registration',
    method: 'post',
    data: data
  })
}

// 修改【请填写功能名称】
export function updateRegistration(data) {
  return request({
    url: '/system/registration',
    method: 'put',
    data: data
  })
}

// 删除【请填写功能名称】
export function delRegistration(coalNumber) {
  return request({
    url: '/system/registration/' + coalNumber,
    method: 'delete'
  })
}
