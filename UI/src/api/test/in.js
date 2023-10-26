import request from '@/utils/request'

// 查询【请填写功能名称】列表
export function listCoal(query) {
  return request({
    url: '/test/coal/list',
    method: 'get',
    params: query
  })
}

// 查询【请填写功能名称】详细
export function getList(coalNumber) {
  return request({
    url: '/test/coal/' + coalNumber,
    method: 'get'
  })
}

export function updateList(data) {
  return request({
    url: '/test/coal/',
    method: 'put',
    data: data
  })
}

