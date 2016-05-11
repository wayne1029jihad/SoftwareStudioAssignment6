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
+ 滑鼠滑過圈圈，圈圈的線會變粗
+ 每個角色會依照其重要性而有不同顏色
+ 不同角色之間在圓上時若有關係，兩者會線連接，如果線越粗，表示其關係越緊密
+ 如果要把角色放到圈圈上，需要很精準的"真的"放在線上
+ 如果角色已經放在圈圈上時，把角色往圈圈內拉，則滑鼠放開時，角色會自動彈回圈圈的線上
+ 如果角色把已經放在圈圈上的角色往圈圈外拉，角色會自動彈回到原本一開始甚麼都沒做的原位置

###做法
+ "Add All""Clear"是用圖形+設定文字寫在Network，然後用滑鼠範圍去判斷按的按鈕是 "Add All"還是"Clear"
+Network裡主要是寫有關小圓圈圈的角色會有的功能，
例如:產生大圓:利用ellipse()，使其長邊和短邊相等即為圓形
	把角色放到圓圈線上:算出圓周位置
				利用:
				+圓的中心點到四周等長的等式可算出圓周位置，如果在圓周內部，則是圓心到任一點的距離會小於等於半徑，即可知道判斷出已在圓上的角色被亂拉後要彈回圓上，
				還是一開始甚麼都沒做的位置
				找到角色在圓的位置:
				計算圓上有幾個角色，藉此知道圓要"平分"成幾份->imply 我們也可以知道角度，圓周上任何一點都可表示為
				(圓心X+radius*cos(theta-->radians),圓心Y+radius*sin(theta->radians))
				[註]processing有提供radians()讓"角度"轉換成弧度制
	把角色從圈圈移除:在Network裡需要有一個ArrayList記住有哪些幾色已經在圓上了，
				然後把想移除的角色依序移除用arraylistname.remove(arrayelement)即可，
				不用去管中間少了一個element，arraylist內部會自己調整順序
	滑鼠移過圈圈會使圈圈的線加粗:使用strokeWeight()可以改變粗細，然後用mouseMoved內的if else判斷是否滑鼠有move過
	角色之間關係連線:	使用bezier()，bezier(x1, y1, x2, y2, x3, y3, x4, y4)，前四組是一條直線的兩個座標，後四個一組，
				也是一條直線兩個座標，然後這兩條直線我設計成平行線，這樣我才能控制端點是兩個有關係的character角色之間關係越緊密，\
				線的粗細越粗，是利用strokeWeight()調整
+MainApplete:主要是寫
			dataloading:
			使用JSONObject,JSONArray去找資料，然後存進ArrayList(和LAB做法完全同)
			只是value的的arraylist存的是integer不是character而已
			選擇集數:
			用鍵盤控制BY keyPressed()
+character:主要是寫
			設定角色基本資料:name,color,target,value,角色位置...
			取得基本資料的method
			實作滑鼠有移過時要有label出現:判斷滑鼠位置，用if else表示在與不在角色上的情況
			
