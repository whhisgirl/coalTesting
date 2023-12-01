import request from '@/utils/request'

//构建图谱渲染
export function getCaseForGraph(query) {
  return request({
    url: '/casedata/casedata/getCaseForGraph',
    method: 'get',
    params: query
  })
}

//图谱 查询
export function getCaseByGraphFind(query) {
  return request({
    url: '/casedata/casedata/getCaseByGraphFind',
    method: 'get',
    params: query
  })
}

//文献案例列表查看
export function listByOption(query) {
  return request({
    url: '/casedata/casedata/listByOption',
    method: 'get',
    params: query
  })
}

//文献案例列表查看 无分页
export function listByOptionWithoutPage(query) {
  return request({
    url: '/casedata/casedata/listByOptionWithoutPage',
    method: 'get',
    params: query
  })
}

//关系图预渲染
export function initGraph(query) {
  return request({
    url: '/casedata/casedata/initGraph',
    method: 'get',
    params: query
  })
}
// 查询案例管理列表
export function listCasedata(query) {
  return request({
    url: '/casedata/casedata/list',
    method: 'get',
    params: query
  })
}


// 查询案例管理列表 无分页
export function listWithoutPage(query) {
  return request({
    url: '/casedata/casedata/listWithoutPage',
    method: 'get',
    params: query
  })
}


// 查询辐射图相关结果
export function searchRadicalResult(query) {
  return request({
    url: '/casedata/casedata/searchRadicalResult',
    method: 'post',
    data: query
  })
}

// 记录浏览日志
export function saveCaseViewLog(id) {
  return request({
    url: '/casedata/casedata/saveCaseViewLog/' + id,
    method: 'get',
  })
}


// 查询案例管理详细
export function getCasedata(id) {
  return request({
    url: '/casedata/casedata/' + id,
    method: 'get'
  })
}

// 新增案例管理
export function addCasedata(data) {
  return request({
    url: '/casedata/casedata',
    method: 'post',
    data: data
  })
}

// 修改案例管理
export function updateCasedata(data) {
  return request({
    url: '/casedata/casedata',
    method: 'put',
    data: data
  })
}

// 删除案例管理
export function delCasedata(id) {
  return request({
    url: '/casedata/casedata/' + id,
    method: 'delete'
  })
}

// 根据条件查询
export function getCaseByFaultPart(query) {
  return request({
    url: '/casedata/casedata/faultPart',
    method: 'get',
    params: query
  })
}

// 获取故障件对应的表格数据
export function selectByFaultId(query) {
  return request({
    url: '/casedata/casedata/selectByFaultId',
    method: 'get',
    params: query
  })
}

// 获取机型对应案例数
export function getPlaneCaseNum(query) {
  return request({
    url: '/casedata/casedata/planeCaseNum',
    method: 'get',
    params: query
  })
}

// 获取数据查询推荐中对应的表格数据（机型、高级搜索）
export function selectTableData(query) {
  return request({
    url: '/casedata/casedata/selectTableData',
    method: 'get',
    params: query
  })
}

//词云 展示案例属性
export function showWordCloud(query) {
  return request({
    url: '/casedata/casedata/showWordCloud',
    method: 'get',
    params: query
  })
}

// 获取故障件
export function getFaultNum(query) {
  return request({
    url: '/casedata/casedata/getFaultNum',
    method: 'get',
    params: query
  })
}

// 所属系统近几年查询
export function getOwningSystem(query) {
  return request({
    url: '/casedata/casedata/getOwningSystem',
    method: 'get',
    params: query
  })
}

// 事件性质近几年查询
export function getEventNature(query) {
  return request({
    url: '/casedata/casedata/getEventNature',
    method: 'get',
    params: query
  })
}

// 查询案例管理列表通过和不通过状态的案例
export function listCasedataCheck(query) {
  return request({
    url: '/casedata/casedata/listCheck',
    method: 'get',
    params: query
  })
}

// 查询案例管理列表,新!
export function listCasedataFind(query) {
  return request({
    url: '/casedata/casedata/listFind',
    method: 'get',
    params: query
  })
}

// 查询案例管理列表
export function listAll(query) {
  return request({
    url: '/casedata/casedata/listNum',
    method: 'get',
    params: query
  })
}

//查询每种故障模式中案例数量
export function listNumsByFaultModel(){
  return request({
    url:'/casedata/casedata/listFMNum',
    method:'get',
  })
}

//修改状态
export function changeCaseStatus(data) {
  return request({
    url: '/casedata/casedata/changeCaseStatus',
    method: 'put',
    data: data
  })
}
//根据密级筛选 案例
export function listByConfidentialLevel(data) {
  return request({
    url: '/casedata/casedata/listByConfidentialLevel',
    method: 'get',
    params: data
  })
}

// 查询字典数据 是否被案例使用
export function searchIfUseDict(query) {
  return request({
    url: '/casedata/casedata/searchIfUseDict',
    method: 'post',
    data: query
  })
}

// 查询案例管理列表
export function selectDescription(query) {
  return request({
    url: '/casedata/casedata/selectDescription',
    method: 'get',
    params: query
  })
}

export function listCaseDesc(query) {
  return request({
    url: '/casedata/casedata/listCaseDes/',
    method: 'get',
    params:query
  })
}
// 清除数据库
export function delAll() {
  return request({
    url: '/casedata/casedata/deleteAll',
    method: 'get'
  })
}
