package plugins.jdk

/**
 * Created with IntelliJ IDEA.
 * User: jjb
 * Date: 12-11-25
 * Time: 下午8:41
 * To change this template use File | Settings | File Templates.
 */



String getTitle(){
    return "Java SDK"
}

Map<String, Object> help_message(language){
    return ["title": "${getTitle()}"
            , "syntax": "[module] <command> [arguments]"
            , "commands" : []
            ]
}
 

// 安装一组功能模块
def install(String[] args){

}


// 删除一组已经安装的模块
def remove(String[] args){

}


// 启动一组模块
def start(String[] args){

}


// 停止一组模块
def stop(String[] args){

}


// 重启一组模块
def restart(String[] args){

}


// 备份系统
def backup(String[] args){

}


// 从备份中恢复数据
def restore(String[] args){

}


// 升级一组模块
def upgrade(String[] args){

}


// 检查是否有新版本
def checkUpdate(String[] args){

}




