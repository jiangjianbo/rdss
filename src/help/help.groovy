package help

/**
 * Created with IntelliJ IDEA.
 * User: jjb
 * Date: 12-11-25
 * Time: 下午3:43
 * To change this template use File | Settings | File Templates.
 */


Map<String, Object> help_message(){
    return ["title": "Research & Development Support System"
            , "syntax": "Syntax: rdss [module] <command> [arguments]"
            , "commands" : [
                    "help" : ["title": "show help message"
                            ,"syntax": ""
                            ,"commands": []]
                    ,"list" : ["title": "列举所有的模块已安装和未安装的模块"
                            ,"syntax": ""
                            ,"commands": []]
                    ,"install" : ["title": "安装一组功能模块"
                            ,"syntax": ""
                            ,"commands": []]
                    ,"remove" : ["title": "删除一组已经安装的模块"
                            ,"syntax": ""
                            ,"commands": []]
                    ,"start" : ["title": "启动一组模块"
                            ,"syntax": ""
                            ,"commands": []]
                    ,"stop" : ["title": "停止一组模块"
                            ,"syntax": ""
                            ,"commands": []]
                    ,"restart" : ["title": "重启一组模块"
                            ,"syntax": ""
                            ,"commands": []]
                    ,"backup" : ["title": "备份系统"
                            ,"syntax": ""
                            ,"commands": []]
                    ,"restore" : ["title": "从备份中恢复数据"
                            ,"syntax": ""
                            ,"commands": []]
                    ,"upgrade" : ["title": "升级一组模块"
                            ,"syntax": ""
                            ,"commands": []]
                    ,"checkUpdate" : ["title": "检查是否有新版本"
                            ,"syntax": ""
                            ,"commands": []]
            ]
    ]
}

