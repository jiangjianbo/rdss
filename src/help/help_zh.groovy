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
            , "syntax": "rdss [module] <command> [arguments]"
            , "commands" : [
                    "help" : ["title": "show help message"
                            ,"syntax": "[模块|命令] [子命令] ..."
                            ,"commands": ["模块":"显示模块的帮助信息"
                                    ,"命令":"显示命令的帮助信息"
                                    ,"子命令":"显示命令中的子命令的帮助信息"
                    ]]
                    ,"list" : ["title": "列举所有的模块已安装和未安装的模块"
                            ,"syntax": ""
                            ,"commands": []]
                    ,"install" : ["title": "安装一组功能模块"
                            ,"syntax": "<模块> [模块] ..."
                            ,"commands": ["模块":"指定要安装的模块，可以多个模块一起安装"]]
                    ,"remove" : ["title": "删除一组已经安装的模块"
                            ,"syntax": "<模块> [模块] ..."
                            ,"commands": ["模块":"指定要卸载的模块，可以多个模块一起卸载"]]
                    ,"start" : ["title": "启动一组模块"
                            ,"syntax": "all | <模块> [模块] ..."
                            ,"commands": ["all": "一次性启动所有的已安装模块"
                                        ,"模块":"指定一个或者多个要启动的模块"
                    ]]
                    ,"stop" : ["title": "停止一组模块"
                            ,"syntax": "all | <模块> [模块] ..."
                            ,"commands": ["all": "一次性停止所有的已安装模块"
                                        ,"模块":"指定一个或者多个要停止的模块"]]
                    ,"restart" : ["title": "重启一组模块"
                            ,"syntax": "all | <模块> [模块] ..."
                            ,"commands": ["all": "一次性重新启动所有的已安装模块"
                                        ,"模块":"指定一个或者多个要重新启动的模块"]]
                    ,"backup" : ["title": "备份系统"
                            ,"syntax": "all | <模块> [模块] ..."
                            ,"commands": ["all": "一次性备份所有的已安装模块"
                                         ,"模块":"指定一个或者多个要备份的模块"]]
                    ,"restore" : ["title": "从备份中恢复数据"
                            ,"syntax": "all | <模块> [模块] ..."
                            ,"commands": ["all": "一次性还原所有的已安装模块的备份"
                                        ,"模块":"指定一个或者多个要还原备份的模块"]]
                    ,"upgrade" : ["title": "升级一组模块"
                            ,"syntax": "all | <模块> [模块] ..."
                            ,"commands": ["all": "一次性升级所有的已安装模块"
                                        ,"模块":"指定一个或者多个要升级的模块"]]
                    ,"checkUpdate" : ["title": "检查是否有新版本"
                            ,"syntax": "all | <模块> [模块] ..."
                            ,"commands": ["all": "一次性检查所有的已安装模块的升级"
                                        ,"模块":"指定一个或者多个要检查升级的模块"]]
            ]
    ]
}

