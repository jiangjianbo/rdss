
/**
 * 维护脚本
 * User: jiangjianbo
 * Date: 12-11-15
 * Time: 下午11:47
 * from https://www.ibm.com/developerworks/java/library/j-pg12144/index.html
 * http://www.javaworld.com/javaworld/jw-10-2004/jw-1004-groovy.html?page=2
 * http://refcardz.dzone.com/refcardz/groovy
 * http://geek.starbean.net/?page_id=202
 */

class Main {
    def ant = new AntBuilder()
    // 基础目录
    String base_dir = "./"
    // 帮助目录
    String help_dir = base_dir + "help/"
    // 扩展功能目录
    String plugins_dir = base_dir + "plugins/"
    // 库文件目录
    String lib_dir = base_dir + "lib/"
    // user.language
    String language = System.getProperty("user.language", "")
    // rdss install directory
    String rdss_dir = System.getProperty("rdss.dir", "/rdss/")
    // rdss program directory
    String rdss_program_dir = System.getProperty("rdss.program.dir", "${rdss_dir}program/")
    // rdss data directory
    String rdss_data_dir = System.getProperty("rdss.data.dir", "${rdss_dir}data/")

    def classpath = ant.path {
        fileset(dir: "${lib_dir}"){
            include(name: "*.jar")
        }
        //pathelement(path: "${build_dir}")
    }

    static void main(String[] args) {
        new Main().run(args)
    }

    void run(String[] args) {
        println args
        if ( args.size() > 0 ) {
            try{
                invokeMethod(args[0], args.size() <= 1? null: args[1..args.size()-1].toArray(new String[0]) )
                println "."
            }catch(groovy.lang.MissingMethodException e){
                println "method not found ${args[0]}"
            }catch(Exception e2){
                println "Error: " + e2
            }
        }
        else {
            install_wizard()
        }
    }

    // 装入并返回一个脚本对象
    private load(File scriptFile){
        GroovyShell shell = new GroovyShell()
        byte[]  content = scriptFile.readBytes()
        def s = shell.parse(new String(content, "utf-8"))

        /*
        GroovyShell shell= new GroovyShell();
        Script scpt = shell.parse("y = x*x");
        Binding binding = new Binding();
        scpt.setBinding(binding);
        binding.setVariable("x", 2);
        scpt.run();
        (int) binding.getVariable("y");
        */
        return s

    }

    private Map<String, Object> loadHelp(){
        File dir = new File(help_dir)
        File f = new File(dir, "help_${language}.groovy")
        def s = f.exists() ? load(f) : load(new File(dir, "help.groovy"))
        return s.help_message()
    }

    private Map<String, Object> plugins = [:]

    private Map<String,Object> loadPlugins(){
        Map<String,Object> plg = [:]
        new File(plugins_dir).eachDir { dir ->
            if( new File(dir, "plugin_${dir.name}.groovy").exists() )
                plg[dir.name] = null
        }

        plugins = plg
        return plg
    }

    private def getPlugin(pluginName){
        if( !plugins.containsKey(pluginName) )
            return null

        if( plugins[pluginName] == null ){
            plugins[pluginName] = load(new File(new File(plugins_dir + pluginName), "plugin_${pluginName}.groovy"))
        }

        try{
            return plugins[pluginName]
        }catch(groovy.lang.MissingMethodException e){
            return null
        }
    }

    // 显示安装向导
    def install_wizard() {
    }

    // 显示帮助信息
    def help(String[] args){
        def hlp = loadHelp()
        if( args.length == 0 ){
            println hlp.title
            println "Syntax: ${hlp.syntax}"
            println ""
            println "Commands:"
            hlp.commands.each{cmd,info ->
                println "    ${cmd}\t${info?.title}"
            }

            def plg = loadPlugins()
            println "Plugins:"
            plg.each{name,plugin ->
                println "    ${name}\t${(plugin?:getPlugin(name))?.title}"
            }
        } else {
            // 检查是否是内置的命令
            String cmdName = args[0]
            if( hlp.commands.containsKey(cmdName)){
                def cmd = hlp.commands[cmdName]
                println "${cmdName}\t${cmd.title}"
                println "Syntax: " + cmd.syntax
                cmd.commands.each{ name, info ->
                    println "    ${name}\t${info}"
                }
            } else {
                // 检查是否是插件的帮助
                def plg = loadPlugins()
                if( plg.containsKey(cmdName))
                {
                    def plugin = plg[cmdName] ?: getPlugin(cmdName)
                    println "Plugin ${cmdName}\t${plugin.title}"
                    def hh = plugin.help_message(language)
                    println "Usage: ${hh.syntax}"
                    hh.commands.each{ name, info ->
                        println "    ${name}\t${info}"
                    }
                } else {
                    println "Error: unknown [${cmdName}], neither command nor plugin name."
                }
            }
        }

        println "."
    }

    // 列举所有的模块已
    def list(){
        def plg = loadPlugins()
        println "Plugins:"
        plg.each{k,v ->
            println "    ${k}\t${getPlugin(k)?.title}"
        }
    }

    private callFunction(String func, String[] plugins){
        def plg = loadPlugins()
        def all = ( plugins.length > 0 && plugins[0] == "all")

        plg.each{name,method ->
            if( all || name in plugins){
                println "${func} ${name}"
                (method?:getPlugin(name)).invokeMethod(func, plugins)
            }
        }
    }

    // 安装一组功能模块
    def install(String[] args){
        callFunction("install", args)
    }


    // 删除一组已经安装的模块
    def remove(String[] args){
        callFunction("remove", args)
    }


    // 启动一组模块
    def start(String[] args){
        callFunction("start", args)
    }


    // 停止一组模块
    def stop(String[] args){
        callFunction("stop", args)
    }


    // 重启一组模块
    def restart(String[] args){
        callFunction("install", args)
    }


    // 备份系统
    def backup(String[] args){
        callFunction("backup", args)
    }


    // 从备份中恢复数据
    def restore(String[] args){
        callFunction("restore", args)
    }


    // 升级一组模块
    def upgrade(String[] args){
        callFunction("upgrade", args)
    }


    // 检查是否有新版本
    def checkUpdate(String[] args){
        callFunction("checkUpdate", args)
    }

}

