
/**
 * 维护脚本
 * User: jiangjianbo
 * Date: 12-11-15
 * Time: 下午11:47
 * from https://www.ibm.com/developerworks/java/library/j-pg12144/index.html
 * http://www.javaworld.com/javaworld/jw-10-2004/jw-1004-groovy.html?page=2
 * http://refcardz.dzone.com/refcardz/groovy
 */

class Main {
    def ant = new AntBuilder()
    // 基础目录
    def base_dir = "./"
    // 扩展功能目录
    def plugins_dir = base_dir + "plugins"
    // 库文件目录
    def lib_dir = base_dir + "lib"

    def classpath = ant.path {
        fileset(dir: "${lib_dir}"){
            include(name: "*.jar")
        }
        //pathelement(path: "${build_dir}")
    }

    static void main(args) {
        new Main().run(args)
    }

    void run(args) {
        if ( args.size() > 0 ) {
            invokeMethod(args[0], null )
        }
        else {
            install_wizard()
        }
    }

    // 装入并返回一个脚本对象
    private load(String script){
        GroovyShell shell = new GroovyShell()
        def s = shell.parse(new File(script))
        //s.method()
        return s
    }

    // 显示安装向导
    def install_wizard() {
    }

    // 显示帮助信息
    def help(){
        println("Research & Development Support System")
        println("Syntax: rdss [module] <command> [arguments]")
        println("command: ")
        println("    help\tshow help message")
        println("    list\t列举所有的模块已安装和未安装的模块")
        println("    install\t安装一组功能模块")
        println("    remove\t删除一组已经安装的模块")
        println("    start\t启动一组模块")
        println("    stop\t停止一组模块")
        println("    restart\t重启一组模块")
        println("    backup\t备份系统")
        println("    restore\t从备份中恢复数据")
        println("    upgrade\t升级一组模块")
        println("    checkupdate\t检查是否有新版本")
        println("module command:")
        println("    install\tinstall module")
        println("    remove\tremove module")
        println("    config\tconfig module")
        println("    start\tstart module")
        println("    stop\tstop module")
        println("    restart\trestart module")
        println("    backup\tbackup module data")
        println("    restore\trestore module data from backup")
        println("    upgrade\tupgrade module")
        println("    checkupdate\tcheck module\'s new version")
        println("    ")
        println("")
        println("")
        println("")
    }

    // 列举所有的模块已
    def list(){
        new File(plugins_dir).listFiles()
    }

    // 安装一组功能模块
    def install(){

    }


    // 删除一组已经安装的模块
    def remove(){

    }


    // 启动一组模块
    def start(){

    }


    // 停止一组模块
    def stop(){

    }


    // 重启一组模块
    def restart(){

    }


    // 备份系统
    def backup(){

    }


    // 从备份中恢复数据
    def restore(){

    }


    // 升级一组模块
    def upgrade(){

    }


    // 检查是否有新版本
    def checkupdate(){

    }



}

