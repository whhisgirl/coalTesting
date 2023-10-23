import request from '@/utils/request'

// 查询指标结果记录列表
export function listIndicators(query) {
  return request({
    url: '/system/indicators/list',
    method: 'get',
    params: query
  })
}

// 查询指标结果记录详细
export function getIndicators(coalNumber) {
  return request({
    url: '/system/indicators/' + coalNumber,
    method: 'get'
  })
}

// 新增指标结果记录
export function addIndicators(data) {
  return request({
    url: '/system/indicators',
    method: 'post',
    data: data
  })
}

// 修改指标结果记录
export function updateIndicators(data) {
  return request({
    url: '/system/indicators',
    method: 'put',
    data: data
  })
}

// 删除指标结果记录
export function delIndicators(coalNumber) {
  return request({
    url: '/system/indicators/' + coalNumber,
    method: 'delete'
  })
}
