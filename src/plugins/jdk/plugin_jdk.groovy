package plugins.jdk

/**
 * Created with IntelliJ IDEA.
 * User: jjb
 * Date: 12-11-25
 * Time: ����8:41
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
 

// ��װһ�鹦��ģ��
def install(String[] args){

}


// ɾ��һ���Ѿ���װ��ģ��
def remove(String[] args){

}


// ����һ��ģ��
def start(String[] args){

}


// ֹͣһ��ģ��
def stop(String[] args){

}


// ����һ��ģ��
def restart(String[] args){

}


// ����ϵͳ
def backup(String[] args){

}


// �ӱ����лָ�����
def restore(String[] args){

}


// ����һ��ģ��
def upgrade(String[] args){

}


// ����Ƿ����°汾
def checkUpdate(String[] args){

}




