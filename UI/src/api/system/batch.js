import request from '@/utils/request'

// 查询【请填写功能名称】列表
export function listBatch(query) {
  return request({
    url: '/system/batch/list',
    method: 'get',
    params: query
  })
}

// 查询【请填写功能名称】详细
export function getBatch(batchNumber) {
  return request({
    url: '/system/batch/' + batchNumber,
    method: 'get'
  })
}

// 新增【请填写功能名称】
export function addBatch(data) {
  return request({
    url: '/system/batch',
    method: 'post',
    data: data
  })
}

// 修改【请填写功能名称】
export function updateBatch(data) {
  return request({
    url: '/system/batch',
    method: 'put',
    data: data
  })
}

// 删除【请填写功能名称】
export function delBatch(batchNumber) {
  return request({
    url: '/system/batch/' + batchNumber,
    method: 'delete'
  })
}
