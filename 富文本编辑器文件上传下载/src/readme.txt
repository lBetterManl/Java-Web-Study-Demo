struts2+ckeditor + ckfinder

1���������̣�struts2��
2������ckeditor
3������ckfinder
4������jar
5������config.xml�޸� 
	enabled = true
	<baseDir></baseDir>
	<baseURL>/ckscxz/userfiles/</baseURL>
6���޸�web.xml
    ����CKEditor��servlet����Ϣ
    struts2���� /* ,ckeditor��servlet���ȱ�struts2����
	���ַ�ʽ��
	1���޸�struts2�������� ��/* �޸�Ϊ*.action��*.do
	2���Զ���CKeditor�Ĺ�����,�������̳�Struts2�Ĺ�����FilterDispatcher
	   ���������http url�ĵ�ַ,Ȼ���ж�URL��ַ���Ƿ����CKEditor��servlet
	   ���ع���"/ckfinder/core/connector/java /*/",
	   ������,struts2�Ͳ����ظ�URL����,��ֱ��ת��,����CKEditor��servlet������;
	   ���������������������ظ�URL����,��struts2������

7��ckeditor config.js����
	config.language =  "zh-cn" ; 
	config.image_previewText = ' ';

	config.filebrowserBrowseUrl =  '/ckscxz/ckfinder/ckfinder.html' ;  
    config.filebrowserImageBrowseUrl =  '/ckscxz/ckfinder/ckfinder.html?type=Images' ;  
    config.filebrowserFlashBrowseUrl =  '/ckscxz/ckfinder/ckfinder.html?type=Flash' ;  
    config.filebrowserUploadUrl =  '/ckscxz/ckfinder/core/connector/java/connector.java?command=QuickUpload&type=Files' ;  
    config.filebrowserImageUploadUrl =  '/ckscxz/ckfinder/core/connector/java/connector.java?command=QuickUpload&type=Images' ;  
    config.filebrowserFlashUploadUrl =  '/ckscxz/ckfinder/core/connector/java/connector.java?command=QuickUpload&type=Flash' ;  
    config.filebrowserWindowWidth = '1000';  
    config.filebrowserWindowHeight = '700';  
    
    ---------------�����ƽ�------------------
    --ͼƬԤ�������滻ckeditor/config.js
    config.image_previewText = " ";
    -----------------------------------
    --ckfinder/ckfinder.js
	--������������½���Ϣ��չʾ   �������ע�� 
    if (!D) this.dV().getChild(0).appendHtml(A || B || y != 4 ? t: u + "\x3c\142\x3e" + k.htmlEncode(a.ed) + "\x3c\057\142\x3e\x3c\x2f\x64\151\166\x3e");
    -----------------------------------
    --���ذ�Ȩ��Ϣ
    �ҵ�<h4 class='message_content'>
    ��Ϊ<h4 style='display:none;' class='message_content'>
    
	 -----------------------------------
     --�����ϴ��ļ����룬���ϴ��ļ�����ʱ�������
    ����취���޸�Դ��FileUploadCommand.class  getFileItemName����
    
    