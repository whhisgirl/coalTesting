import request from '@/utils/request'

// 查询【请填写功能名称】列表
export function listIndicators(query) {
  return request({
    url: '/system/indicators/list',
    method: 'get',
    params: query
  })
}

// 查询【请填写功能名称】列表
export function listBatchAndIndicators(query) {
  return request({
    url: '/system/indicators/listBatchAndIndicators',
    method: 'get',
    params: query
  })
}

// 查询【请填写功能名称】详细
export function getIndicators(coalNumber) {
  return request({
    url: '/system/indicators/' + coalNumber,
    method: 'get'
  })
}

// 新增【请填写功能名称】
export function addIndicators(data) {
  return request({
    url: '/system/indicators',
    method: 'post',
    data: data
  })
}

// 修改【请填写功能名称】
export function updateIndicators(data) {
  return request({
    url: '/system/indicators',
    method: 'put',
    data: data
  })
}

// 删除【请填写功能名称】
export function delIndicators(coalNumber) {
  return request({
    url: '/system/indicators/' + coalNumber,
    method: 'delete'
  })
}
