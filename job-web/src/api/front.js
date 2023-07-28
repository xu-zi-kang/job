import request from '@/utils/request';

export function channel_tree(data) {
    return request({
        url: 'f/channel/tree',
        method: 'post',
        data: data
    })
}

export function article_detail(id) {
    return request({
        url: 'f/article/detail',
        method: 'post',
        params: {"id": id}
    })
}


export function article_detail2(title) {
    return request({
        url: 'f/article/detail2',
        method: 'post',
        params: {"title": title}
    })
}


// 按id查询职业
export function post_detail(id) {
    return request({
        url: 'post/detail3',
        method: 'post',
        params: {"id": id}
    })
}



export function article_query(data) {
    return request({
        url: 'f/article/query',
        method: 'post',
        data: data
    })
}

export function channel_detail(id) {
    return request({
        url: 'f/channel/detail',
        method: 'post',
        params: {"id": id}
    })
}

export function post_query(data) {
    return request({
        url: 'f/post/query',
        method: 'post',
        data: data
    })
}




export function student_create(data) {
    return request({
        url:'f/register/student_create',
        method:'post',
        data:data
    });
}

export function company_create(data) {
    return request({
        url:'f/register/company_create',
        method:'post',
        data:data
    });
}