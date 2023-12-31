import request from '@/utils/request';

export function create(data) {
    return request({
        url: 'predict/create',
        method: 'post',
        data: data
    })
}

export function update(data) {
    return request({
        url: 'predict/update',
        method: 'post',
        data: data
    })
}

export function del(ids) {
    return request({
        url: 'predict/delete',
        method: 'post',
        params: {"ids": ids}
    })
}


export function detail(id) {
    return request({
        url: 'predict/detail',
        method: 'post',
        params: {"id": id}
    })
}


export function query(data) {
    return request({
        url: 'predict/query',
        method: 'post',
        data: data
    })
}
