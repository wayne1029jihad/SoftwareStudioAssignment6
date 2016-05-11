# Software Studio Assignment 6
## Notes
+ You will have to import the libraries on your own. All the libraries are provided on iLMS.
+ Even you followed the design TA shown in the video, you still have to explain the control of the program in the next section.

## Explanation of the Design

### Operation
+ Clicking on the button "Add All": users can add all the characters into network.
+ Clicking on the button "Clear": users can remove all the characters on the circle from network.
+ Hovering on the character: the name of the character will be revealed.
+ By dragging the little circle and drop it in the big circle, the character will be added to the network.
+ By pressing key 1~7 on the keyboard, users can switch between episodes.
+ �ƹ��ƹL���A��骺�u�|�ܲ�
+ �C�Ө���|�̷Ө䭫�n�ʦӦ����P�C��
+ ���P���⤧���b��W�ɭY�����Y�A��̷|�u�s���A�p�G�u�V�ʡA��ܨ����Y�V��K
+ �p�G�n�⨤������W�A�ݭn�ܺ�Ǫ�"�u��"��b�u�W
+ �p�G����w�g��b���W�ɡA�⨤�⩹��餺�ԡA�h�ƹ���}�ɡA����|�۰ʼu�^��骺�u�W
+ �p�G�����w�g��b���W�����⩹���~�ԡA����|�۰ʼu�^��쥻�@�}�l�ƻ򳣨S�������m

###���k
+ "Add All""Clear"�O�ιϧ�+�]�w��r�g�bNetwork�A�M��ηƹ��d��h�P�_�������s�O "Add All"�٬O"Clear"
+Network�̥D�n�O�g�����p���骺����|�����\��A
�Ҧp:���ͤj��:�Q��ellipse()�A�Ϩ����M�u��۵��Y�����
	�⨤������u�W:��X��P��m
				�Q��:
				+�ꪺ�����I��|�P�����������i��X��P��m�A�p�G�b��P�����A�h�O��ߨ���@�I���Z���|�p�󵥩�b�|�A�Y�i���D�P�_�X�w�b��W������Q�éԫ�n�u�^��W�A
				�٬O�@�}�l�ƻ򳣨S������m
				��쨤��b�ꪺ��m:
				�p���W���X�Ө���A�Ǧ����D��n"����"���X��->imply �ڭ̤]�i�H���D���סA��P�W����@�I���i��ܬ�
				(���X+radius*cos(theta-->radians),���Y+radius*sin(theta->radians))
				[��]processing������radians()��"����"�ഫ�����ר�
	�⨤��q��鲾��:�bNetwork�̻ݭn���@��ArrayList�O�����ǴX��w�g�b��W�F�A
				�M���Q����������̧ǲ�����arraylistname.remove(arrayelement)�Y�i�A
				���Υh�ޤ����֤F�@��element�Aarraylist�����|�ۤv�վ㶶��
	�ƹ����L���|�ϰ�骺�u�[��:�ϥ�strokeWeight()�i�H���ܲʲӡA�M���mouseMoved����if else�P�_�O�_�ƹ���move�L
	���⤧�����Y�s�u:	�ϥ�bezier()�Abezier(x1, y1, x2, y2, x3, y3, x4, y4)�A�e�|�լO�@�����u����Ӯy�СA��|�Ӥ@�աA
				�]�O�@�����u��Ӯy�СA�M��o������u�ڳ]�p������u�A�o�˧ڤ~�౱����I�O��Ӧ����Y��character���⤧�����Y�V��K�A\
				�u���ʲӶV�ʡA�O�Q��strokeWeight()�վ�
+MainApplete:�D�n�O�g
			dataloading:
			�ϥ�JSONObject,JSONArray�h���ơA�M��s�iArrayList(�MLAB���k�����P)
			�u�Ovalue����arraylist�s���Ointeger���Ocharacter�Ӥw
			��ܶ���:
			����L����BY keyPressed()
+character:�D�n�O�g
			�]�w����򥻸��:name,color,target,value,�����m...
			���o�򥻸�ƪ�method
			��@�ƹ������L�ɭn��label�X�{:�P�_�ƹ���m�A��if else��ܦb�P���b����W�����p
			
