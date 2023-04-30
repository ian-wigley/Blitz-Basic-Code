;;;;;;;;;;;;;;;;;;;;;;;;;
;     Jet Pac Remake    ;
;  Blitz basic version  ;
; written by Ian Wigley ;
;;;;;;;;;;;;;;;;;;;;;;;;;

Global switch_right=False ; switch variable used in walking animation timer
Global switch_left=False  ; as above !

Global Level_Timer
Global timer=0
Global bitmap=True
Global key1=False
Global flame_timer=0
Global walking_left_timer=0, walking_right_timer=0
Global flying_left_timer=0, flying_right_timer=0
Global meator_bullet_timer=0, meator_ledges_timer=0

Global fntariala,fntarialb

Global trip=False      ; fire left & right reset trips after collsion has taken place !
Global trip_left=False
Global trip_right=False

Global f1=True	;variable display lists !!
Global f2=False
Global f3=False

Global x=100  ; text horizontal position
Global y=200  ; text vertical position
Global b_page=0
Global rocket_pt1_added=False
Global rocket_pt2_added=False
Global verpos=100
Global horpos=250

Global level=1
Global flame=46
Global rocket_off_screen=False
Global game_reset=False

Global fire=False
Global fireleft=False
Global fireright=False

Global offscreen=False

Global r0horpos=500			;set up rocket parts
Global r0verpos=525
Global r1horpos=640
Global r1verpos=100
Global r2horpos=150
Global r2verpos=168
Global r3horpos=500
Global r3verpos=580

Global ledge=False

Global bonustimer=0
Global bonuson=False

;define bouns type
Type bonus
	Field bonusverpos		;vertical position
	Field bonushorpos		;horizontal position
	Field b_spritepage		;bonus sprite image
    Field bonusposition
End Type

;define fire type
Type fire
	Field firehorpos
	Field fireverpos
	Field f_spritepage
End Type

Const numberofmeators = 12
Global meators=numberofmeators

;define meator TYPE
Type meator
	Field meator_explode  	;explosion flag
	Field mverpos         	;vertical position
	Field mhorpos         	;horizontal position
	Field m_spritepage    	;meator sprite image
    Field m_collision=False ;meator collision flag
    Field m_imagecollide=False
End Type
	
;define rocket type
Type rocket
	Field rverpos			;vertical position
	Field rhorpos			;horizontal position
	Field r_spritepage		;rocket sprite image
End Type	
	
Global walking=False, up=False, down=True 		;if false then were flying !!!
Global man_Left=False, man_Right=True

Global walking_timer=0

Global s_left=15
Global s_right=8

Global lives=4, lost_live=False
Global game_on=False, game_off=False     ;True
Global score=0, hiscore=0

Global Stopper=False
Global letgo1=False
Global letgo2=False

Global cantmove1=True
Global cantmove2=False

Global rocket_clr_take_off=False

Const SCREEN_WIDTH = 800
Const SCREEN_HEIGHT = 600

Graphics SCREEN_WIDTH,SCREEN_HEIGHT,0,2;1 ; maximum window size !
SetBuffer BackBuffer()

Cls

Global sprites = LoadAnimImage("graphics\sprites.png",64,64,0,(16*3))
Global bullet  = LoadImage("graphics\bullet.png")
Global screen  = LoadImage("graphics\screen.png")
Global screen1 = LoadImage("graphics\loading.png")
Global Lazer   = LoadSound("graphics\fire.wav")
Global hit     = LoadSound("graphics\hit.wav")
Global died    = LoadSound("graphics\died.wav")
Global music   = PlayMusic("graphics\overgrown.mod")

;MaskImage sprites,0,0,0 ; mask off outside of jetman

fntariala=LoadFont("arial",24,True,False,False)
fntarialb=LoadFont("arial",12,True,False,False)

;For a=0 To (16*3)
;MaskImage sprites,0,0,0 ; mask off outside of jetman
;Next

; See if the image was loaded successfully (the "jetman" will be 0 if not)
;If mansize = 0 Then
;   Text 100,100,"Invalid Image!"    ; tell the user it was invalid if 0
;Else
;EndIf

While Not KeyHit(1)
Cls

title_functions()
game_functions()

Flip
Wend
FreeFont fntariala
FreeFont fntarialb
End

;////////////////////////////////////
;/ Title screen functions and stuff /
;////////////////////////////////////

Function title_functions()
If game_on=False
If bitmap=True Then
DrawImage(screen1),0,0
timer=timer+1 If timer=100 bitmap=False
EndIf
;If game_on=False
If bitmap=False
If score>hiscore Then hiscore=score
score=0
level=1
SetFont fntariala                       
Text 100,20,Mid$("SCORE 0"+score,True)
Text 345,20,Mid$("HI-SCORE 0"+hiscore,True)
Text 680,20,Mid$("LIVES "+lives,True)
If key1=False
;SetFont fntarialb
Text 335,100,Mid$("JETPAC REMAKE                                      ",True)
Text 290,200,Mid$("Press Key I for instructions                       ",True)
Text 260,240,Mid$("Press Space Key to start the game                  ",True)
Text 260,280,Mid$("Press ESCape Key to exit the game                  ",True)
Text 270,440,Mid$("Original game (C) 1983 A.C.G.                      ",True)
Text 220,470,Mid$("This Remake written by Ian Wigley in 2005          ",True)
Text 195,500,Mid$("Music by ????  All I know is its called overgrown  ",True) 
Text 330,530,Mid$("Beta Release 1.02                                  ",True)   
EndIf
If key1=True
Text 350,100,Mid$("INSTRUCTIONS                                       ",True)
Text 200,160,Mid$("Press the Return Key to go back to main screen     ",True)
Text 260,200,Mid$("Press Space Key to start the game                  ",True)
Text 180,340,Mid$("Using the arrow keys guide the jet man around each ",True)
Text 240,380,Mid$("level in his quest to rebuild the rockets          ",True)
Text 250,420,Mid$("Pressing the Ctrl key fires the bullets            ",True)
Text 210,460,Mid$("Look out for any bonus items that may appear       ",True)

EndIf

If KeyDown(23) Then key1=True
If KeyDown(28) Then key1=False
If KeyDown(57) Then 
 lives=4
 launchbonus()
 launchbullet()
 For i=0 To meators 		;Setup the meators with a loop
 Launchmeators()
 Next
 game_on=True 
 key1=False
EndIf

EndIf
EndIf
End Function

;////////////////////////////////
;/ All of the in game functions /
;////////////////////////////////
Function game_functions()
If game_on=True
;StopChannel music
PauseChannel music
display_text()
updatemeators()
updatebonus()
updatebullet()
meators_and_man_collision()
meators_and_ledges_collision()
bonus_and_man_collision()
bonus_and_ledges_collision()
remove_stray_meators()
draw_n_test_sprites()
keyboard()
animate_in_flight()
have_we_let_go1()
have_we_let_go2()
are_we_walking()
collision_check_ledge1()
collision_check_ledge2()
collision_check_ledge3()
collision_check_ledge4()
collision_check_rocket_1()
collision_check_rocket_2()
check_rocket_part1()
check_rocket_part2()
rocket_launch()
next_level()
lose_a_live()

;debug()
End If
End Function

;//////////////////////////////
;/ Draws all in game graphics /
;//////////////////////////////

Function draw_n_test_sprites()

DrawImage(screen),0,0
DrawImage(sprites),horpos,verpos,b_page

If level=1 Then
DrawImage(sprites),r1horpos,r1verpos,40
DrawImage(sprites),r2horpos,r2verpos,36
DrawImage(sprites),r0horpos,r0verpos,32 
Else
If level=2 Then
DrawImage(sprites),r1horpos,r1verpos,41
DrawImage(sprites),r2horpos,r2verpos,37
DrawImage(sprites),r0horpos,r0verpos,33
Else
If level=3 Then
DrawImage(sprites),r1horpos,r1verpos,42
DrawImage(sprites),r2horpos,r2verpos,38
DrawImage(sprites),r0horpos,r0verpos,34
Else
If level=4 Then
DrawImage(sprites),r1horpos,r1verpos,43
DrawImage(sprites),r2horpos,r2verpos,39
DrawImage(sprites),r0horpos,r0verpos,35
EndIf
EndIf
EndIf
EndIf

DrawImage(sprites),r3horpos,r3verpos,flame		; dont draw flame yet !
If horpos=(0) Then horpos=horpos+2         		;stop man going off screen!
If horpos=>760 Then horpos=horpos-2 
If verpos=(40) Then verpos=verpos+2
If walking=False And verpos<(580-63) And verpos>(40) verpos=verpos+1
End Function

;///////////////////////////
;/ Display score,lives etc /
;///////////////////////////
Function display_text()
SetFont fntariala                       
Text 100,20,Mid$("SCORE 0"+score,True)
Text 345,20,Mid$("HI-SCORE 0"+hiscore,True)
Text 680,20,Mid$("LIVES "+lives,True)
SetFont fntarialb
End Function

;//////////////
;/ Debug text /
;//////////////
;Function debug()
;If debug=True
;If f1=True Then
;Text 320,95,Mid$("Jet Man Variables",True) 
;Text 320,110,Mid$("fire      "+fire,True) 
;Text 320,120,Mid$("horpos    "+horpos,True)
;Text 320,130,Mid$("verpos    "+verpos,True)
;Text 320,140,Mid$("b_page    "+b_page,True)
;Text 320,150,Mid$("fire left "+fireleft,True)
;Text 320,160,Mid$("fire right"+fireright,True)
;Text 320,170,Mid$("man_left  "+man_left,True)
;Text 320,180,Mid$("man_right "+man_right,True)
;Text 320,190,Mid$("lives     "+lives,True)
;Text 320,200,Mid$("level     "+level,True)
;Text 320,210,Mid$("walking   "+walking,True)
;Text 320,220,Mid$("up        "+up,True)
;Text 320,230,Mid$("down      "+down,True)
;Text 320,240,Mid$("walk right"+s_right,True)
;Text 320,250,Mid$("walk left "+s_left,True)
;Text 320,260,Mid$("offscreen "+offscreen,True)
;Else 
;If f2=True Then
;f1=False f3=False
;Text 320,95,Mid$("Meator Variables",True)
;Text 320,110,Mid$("meator horpos  "+mhorpos,True)
;Text 320,120,Mid$("meator explode "+meator_explode,True) 
;Text 320,130,Mid$("meat_trip_left "+meat_trip_left,True)
;Text 320,140,Mid$("meat_trip_right"+meat_trip_right,True)
;Text 320,150,Mid$("bullet horpos  "+firehorpos,True)
;Text 320,160,Mid$("bullet verpos  "+fireverpos,True)
;Text 320,170,Mid$("top of rocket  "+rocket_pt1_added,True)
;Text 320,180,Mid$("rocket clear for take off "+rocket_clr_take_off,True)
;Text 320,190,Mid$("cantmove2      "+cantmove2,True)
;Text 320,200,Mid$("letgo2         "+letgo2,True)
;Text 320,210,Mid$("r2horpos       "+r2horpos,True)
;Text 320,220,Mid$("r2verpos       "+r2verpos,True)
;Text 320,230,Mid$("cantmove1      "+cantmove1,True)
;Text 320,240,Mid$("letgo1         "+letgo1,True)
;Text 320,250,Mid$("r1horpos       "+r1horpos,True)
;Text 320,260,Mid$("r1verpos       "+r1verpos,True)
;Else 
;If f3=True Then
;f1=False f2=False
;Text 320,95,Mid$("Fire & various Variables",True)
;Text 320,110,Mid$("bullet     "+bullet,True)
;Text 320,120,Mid$("firehorpos "+firehorpos,True) 
;Text 320,130,Mid$("horpos     "+horpos,True)
;Text 320,140,Mid$("fireverpos "+fireverpos,True)
;Text 320,150,Mid$("verpos     "+verpos,True)
;Text 320,170,Mid$("rocket_pt1_added"+rocket_pt1_added,True)
;Text 320,180,Mid$("rocket_pt2_added"+rocket_pt2_added,True)
;Text 320,190,Mid$("rocket clear for take off "+rocket_clr_take_off,True)
;Text 320,200,Mid$("r2horpos       "+r2horpos,True)
;Text 320,210,Mid$("r2verpos       "+r2verpos,True)
;Text 320,220,Mid$("cantmove1      "+cantmove1,True)
;Text 320,230,Mid$("cantmove2      "+cantmove2,True)
;Text 320,240,Mid$("letgo1         "+letgo1,True)
;Text 320,250,Mid$("letgo2         "+letgo2,True)
;Text 320,260,Mid$("r1horpos       "+r1horpos,True)
;Text 320,270,Mid$("r1verpos       "+r1verpos,True)
;Text 320,280,Mid$("stopper        "+stopper,True)
;EndIf
;EndIf
;EndIf
;EndIf
;End Function

;///////////////////////
;/ Keyboard function ! /
;///////////////////////
Function keyboard ()
If rocket_clr_take_off=False Then
If KeyDown(29) Then fire=True ;firebullet() 
If walking=True And KeyDown(200) Then walking=False verpos=verpos-2 up=True down=False;csrup

If KeyDown(200) And KeyDown(29) Then fire=True
If KeyDown(208) And KeyDown(29) Then fire=True
If walking=False And KeyDown(200) Then verpos=verpos-2 up=True down=False;csrup 
If walking=False And KeyDown(208) Then verpos=verpos+1 up=False down=True;csr dwn

If KeyDown(203) Then horpos=horpos-1 man_Left=True man_right=False ;;faceleft=True faceright=False
If walking=True And KeyDown(203) Then horpos=horpos-1 man_Left=True switch_left=True ;s_left=s_left-1

If KeyDown(205) Then horpos=horpos+1 man_Right=True man_left=False ;;faceleft=False faceright=True
If walking=True And KeyDown(205) Then horpos=horpos+1 man_Right=True switch_right=True ;s_right=s_right+1

If Not KeyDown(205) switch_right=False ; If the right arrow is not pressed stop walking animation !
If Not KeyDown(203) switch_left=False  ; If the left arrow is not pressed stop walking animation !

;If KeyDown(59) Then f1=True f2=False f3=False
;If KeyDown(60) Then f2=True f1=False f3=False
;If KeyDown(61) Then f3=True f1=False f2=False
EndIf 
End Function

;////////////////////////////////////////////////////////
;/ Function to Run through animation sequence in flight /
;////////////////////////////////////////////////////////
Function animate_in_flight()
If rocket_clr_take_off=False And walking=False And man_left=True Then 
 If MilliSecs()>flying_left_timer + 50 Then
  flying_left_timer=MilliSecs()
  b_page=b_page+1 If b_page=>7 Then b_page=4
 EndIf
EndIf
If rocket_clr_take_off=False And walking=False And man_right=True Then 
 If MilliSecs()>flying_right_timer + 50 Then
  flying_right_timer=MilliSecs()
  b_page=b_page+1 If b_page=>3 Then b_page=0
 EndIf
EndIf
End Function

Function lose_a_live()
If lost_live=True And lives=>0 Then
 rocket_clr_take_off=False		;rocket not clear for takeoff reset flag  <<<< this reset works here!!
 Stopper=False
 letgo1=False
 letgo2=False
 cantmove1=True
 cantmove2=False
 rocket_pt1_added=False
 rocket_pt2_added=False
 letgo1=False					;reset letgo1
 letgo2=False					;reset letgo2
 verpos=100						;reset jetman
 horpos=250
 r0horpos=500					;reset rocket parts
 r0verpos=525
 r1horpos=640
 r1verpos=100
 r2horpos=150
 r2verpos=168
 r3horpos=500
 r3verpos=580
 flame=46
 fire=False
 lives=lives-1
 lost_live=False
 walking=False
 For m.meator = Each meator
 Delete m
 Next
 For i=0 To meators 		;Setup the meators with a loop
 Launchmeators()
 Next
If lives=0 Then 
 game_on=False
 bonustimer=0
; PlayMusic music
 ResumeChannel music
 For b.bonus = Each bonus
  Delete b
 Next
 For m.meator = Each meator
  Delete m
 Next
EndIf
End If
End Function

;//////////////////////////////////////////////
;/ Rocket Take off function & level increment /
;//////////////////////////////////////////////
Function rocket_launch()
If rocket_clr_take_off=True Then
flame=44
 b_page=30
  horpos=600
   verpos=-40
    r0verpos=r0verpos-1
    r1verpos=r1verpos-1
    r2verpos=r2verpos-1
    r3verpos=r3verpos-1
 	 If MilliSecs()>flame_timer + 100 Then
      flame_timer=MilliSecs()
      flame=(flame+1) If flame=46 Then flame=44
     EndIf
 If r3verpos=-60 Then rocket_off_screen=False game_reset=True
EndIf
End Function

;///////////////////
;/ Goto next level /
;///////////////////
Function Next_level()
; If rocket_off_screen=True Then
 If game_reset=True Then		;has the next level been reached, yes then reset all parts
  level=level+1					;increment level counter
  rocket_clr_take_off=False		;rocket not clear for takeoff reset flag  <<<< this reset works here!!
  cantmove1=True
  cantmove2=False
  stopper=False
  letgo1=False					;reset letgo1
  letgo2=False					;reset letgo2
  verpos=100					;reset jetman
  horpos=250
  r0horpos=500					;reset rocket parts
  r0verpos=525
  r1horpos=640
  r1verpos=100
  r2horpos=150
  r2verpos=168
  r3horpos=500
  r3verpos=580
  flame=46						;turn off flame
  walking=False
  score=score+100
  For m.meator = Each meator
   Delete m
  Next
  For i=0 To meators 		;Setup the meators with a loop
   Launchmeators()
  Next
 EndIf
 If level=5 Then level=1
game_reset=False
End Function

;//////////////////////////////////////
;/ Collision check with rocket part 1 /
;//////////////////////////////////////
Function collision_check_rocket_1()
If cantmove1=False And ImagesCollide(sprites,horpos,verpos,frame0,sprites,r1horpos,r1verpos,frame40) rocket_pt1_added=True; check collision man & rock
End Function

;//////////////////////////////////////
;/ Collision check with rocket part 2 /
;//////////////////////////////////////
Function collision_check_rocket_2()
If cantmove2=False And ImagesCollide(sprites,horpos,verpos,frame0,sprites,r2horpos,r2verpos,frame36) rocket_pt2_added=True; check collision man & rock
End Function

;////////////////////////////////////////////////////////////////////////////////////////
;/ Function move rocket parts around with jetman until in correct position to let go !! /
;////////////////////////////////////////////////////////////////////////////////////////
Function check_rocket_part1()
If rocket_pt1_added=True r1verpos=verpos+1 r1horpos=horpos+3 ;top part
 If r1horpos<=501 cantmove1=True letgo1=True r1horpos=501 rocket_pt1_added=False
End Function

Function check_rocket_part2()
If rocket_pt2_added=True r2verpos=verpos+1 r2horpos=horpos+3 ;mid section
 If r2horpos=>500 cantmove2=True letgo2=True r2horpos=501 rocket_pt2_added=False
End Function

Function have_we_let_go1()
;If r1horpos=500 And cantmove1=True r1verpos=r1verpos+2
If rocket_clr_take_off=False And letgo1=True r1verpos=r1verpos+1 cantmove1=True cantmove2=True
 If r1verpos>=426 r1verpos=426 ;rocket_clr_take_off=True flame=44 
  If r1verpos=426 And r1horpos=501 And r2verpos=471 And r2horpos=501 rocket_clr_take_off=True flame=44
  If rocket_clr_take_off=True stopper=False
End Function

Function have_we_let_go2()
If rocket_clr_take_off=False And letgo2=True r2verpos=r2verpos+1
 If stopper=False And r2verpos>=471 Then cantmove1=False stopper=True
  If stopper=True r2verpos=471
End Function


;If rocket_clr_take_off=False And walking=False And man_left=True Then 
; If MilliSecs()>flying_left_timer + 50 Then
;  flying_left_timer=MilliSecs()
;  b_page=b_page+1 If b_page=>7 Then b_page=4
; EndIf
;EndIf







;//////////////////////////////////
;/ Check to see if we are walking /
;//////////////////////////////////
Function are_we_walking()
If rocket_clr_take_off=False And walking=True And man_right=True And switch_right=True Then 
If MilliSecs()>walking_timer + 100 Then
  walking_timer=MilliSecs()
  b_page=b_page+1 If b_page=>11 Then b_page=8
 EndIf
 
Else

If rocket_clr_take_off=False And walking=True And man_left=True And switch_left=True Then
;b_page=s_left Delay 15 If s_left=<12 Then s_left=15
 If MilliSecs()>walking_timer + 100 Then
  walking_timer=MilliSecs()
  b_page=b_page-1 If b_page=<12 Then b_page=15 	  
 End If
EndIf
EndIf
End Function

;////////////////////////////////
;/ Collision check with ledge 1 /			720 verpos ;146
;////////////////////////////////
Function collision_check_ledge1()
 If ImageRectCollide(sprites,horpos,verpos,frame1,602,150,126,26)=1 Then 
 If horpos=>(625-64) And horpos=<(625+100) And verpos=>(155-64) walking=True verpos=(155-64)
 If man_right=True Then b_page=8   ;enable right spritepage
 If man_left=True Then b_page=15   ;enable left spritepage
Else
 If walking=True And horpos=<560 And verpos=(155-64) walking=False horpos=horpos-20
 If walking=True And horpos=>720 And verpos=(155-64) walking=False horpos=horpos+20
 If horpos=>551 And horpos=<552 And verpos=>(156-50) And verpos<=(156+10) Then horpos=551;Left
 If horpos=>729 And horpos=<730 And verpos=>(156-50) And verpos<=(156+10) Then horpos=730;right
 If horpos=>(625-64) And horpos=<(625+95) And verpos=>(157-64) And verpos<=(157+18) Then verpos=verpos+2 walking=False;bottom
EndIf
;Color 255,255,255
;Rect 602,150,146,26,solid=1
End Function

;////////////////////////////////
;/ Collision check with ledge 2 / 
;////////////////////////////////
Function collision_check_ledge2()			
If ImageRectCollide(sprites,horpos,verpos,frame1,102,224,126,26)=1 Then
 If horpos=>(125-64) And horpos=<(125+95) And verpos=>(229-64) walking=True verpos=(229-64) ;top 
 If man_right=True Then b_page=8 
 If man_left=True Then b_page=15
Else
 If walking=True And horpos=<(125-64) And verpos=(229-64) walking=False horpos=horpos-20 
 If walking=True And horpos=>(125+95) And verpos=(229-64) walking=False horpos=horpos+20
 If horpos=>51 And horpos=<52 And verpos=>(230-50) And verpos<=(230+10) Then horpos=51;Left
 If horpos=>229 And horpos=<230 And verpos=>(230-50) And verpos<=(230+10) Then horpos=230;right
 If horpos=>(125-64) And horpos=<(125+95) And verpos=>(232-64) And verpos<=(232+18) Then verpos=verpos+2 walking=False
EndIf
;Color 255,255,255
;Rect 102,224,146,26,solid=1
End Function

;////////////////////////////////
;/ Collision check with ledge 3 /    
;////////////////////////////////
Function collision_check_ledge3()
 If ImageRectCollide(sprites,horpos,verpos,frame1,380,300,80,26)=1 Then
 If horpos=>(338) And horpos=<(450) And verpos=>(305-64) walking=True verpos=(305-64);top of ledge
; If horpos=>(345) And horpos=<(440) And verpos=>(305-64) walking=True verpos=(305-64)
 If man_right=True b_page=8
 If man_left=True b_page=15
Else 
; If walking=True And horpos=<(345) And verpos=(305-64) walking=False horpos=horpos-20
 If walking=True And horpos=<(338) And verpos=(305-64) walking=False horpos=horpos-20  
 If walking=True And horpos=>(450) And verpos=(305-64) walking=False horpos=horpos+20
; If walking=True And horpos=>(440) And verpos=(305-64) walking=False horpos=horpos+20
 If horpos=>325 And horpos=<326 And verpos=>(306-50) And verpos<=(306+10) Then horpos=325;Left
 If horpos=>459 And horpos=<460 And verpos=>(306-50) And verpos<=(306+10) Then horpos=460;right
 If horpos=>(338) And horpos=<(450) And verpos=>(306-64) And verpos<=(306+18) Then walking=False verpos=verpos+1 ;bottom 
; If horpos=>(345) And horpos=<(440) And verpos=>(306-64) And verpos<=(306+18) Then walking=False verpos=verpos+1 ;bottom
EndIf
;Color 255,255,255
;Rect 375,300,100,26,solid=1
;Color 255,0,255
;Rect 345,300,100,26,solid=1
End Function

;/////////////////////////////////////////////
;/ Collision check with ledge 4 (the Floor!) /
;/////////////////////////////////////////////
Function collision_check_ledge4()
If ImageRectCollide(sprites,horpos,verpos,frame1,000,575,800,26)=1 Then 
 If horpos=>(000) And horpos=<(800) And verpos=>(580-64) walking=True verpos=(580-64) 
 If man_right=True b_page=8
 If man_left=True b_page=15
EndIf
;Color 255,255,255
;Rect 000,575,800,26,solid=1
End Function

;/////////////////////////////////////////////
;/ Function to initalise meators using types /
;/////////////////////////////////////////////
Function launchmeators()
 m.meator = New meator
 m\mverpos = Rnd(040,540)
 m\mhorpos = Rnd(780,980)
 m\m_spritepage = 19
 m\m_imagecollide=False
End Function

;///////////////////////////////////////////////////
;/ Function to move all of the meators using types /
;///////////////////////////////////////////////////
Function updatemeators()
;Level_Timer=MilliSecs()
For m.meator = Each meator		;loop thro all of the meator variables
 m\mhorpos=m\mhorpos-2 
  If m\mhorpos<-50 Then			;if meators go off screen then reset them and
   m\mhorpos=800				;randomly reposition in the verticle position
   m\mverpos=Rnd(040,540) 
  EndIf 
 DrawImage (sprites),m\mhorpos,m\mverpos,m\m_spritepage
Next
End Function

;////////////////////////////////////////////////////////////////////////
;/ Function to check for collision of the man & the meators using types /
;////////////////////////////////////////////////////////////////////////
Function meators_and_man_collision()
For m.meator = Each meator		;loop thro all of the meator variables
  If ImagesCollide(sprites,horpos,verpos,0,sprites,m\mhorpos,m\mverpos,0) Then 
	PlaySound died
	Delete m					;delete the meator that you just collided with
    lost_live=True				;enable the lose a life function
    launchmeators()				;launch a new meator
	EndIf
Next
End Function

;////////////////////////////////////////////////////////////////////////
;/ Function to check for collision of ledges  & the meators using types /
;////////////////////////////////////////////////////////////////////////
Function meators_and_ledges_collision()
For m.meator = Each meator		;loop thro all of the meator variables
 If ImageRectCollide(sprites,m\mhorpos,m\mverpos,frame1,602,150,126,26)=1 Or ImageRectCollide(sprites,m\mhorpos,m\mverpos,frame1,102,224,126,26)=1 Or ImageRectCollide(sprites,m\mhorpos,m\mverpos,frame1,380,300,80,26)=1 Then
  If MilliSecs()>meator_ledges_timer + 50 Then
   meator_ledges_timer=MilliSecs()
   m\m_spritepage=m\m_spritepage-1 
  EndIf
  If m\m_spritepage=<16 Then 
   Delete m
	launchmeators()
   EndIf	
  EndIf
Next
End Function

;//////////////////////////////////////////
;/ Function to initialise the BONUS items /
;//////////////////////////////////////////
Function launchbonus()
 b.bonus = New bonus
 b\bonusverpos = 20
; b\bonushorpos = Rnd (040,780)
 b\bonusposition = Rnd (0,4)
 b\b_spritepage = Rnd (20,25)
  Select b\bonusposition
   Case 0
    b\bonushorpos=40
   Case 1
    b\bonushorpos=280
   Case 2
    b\bonushorpos=400
   Case 3
    b\bonushorpos=550
   Case 4 
    b\bonushorpos=750
  End Select
End Function

;////////////////////////////////
;/ Function to Draw BONUS items /
;////////////////////////////////
Function updatebonus()
 bonustimer=bonustimer+1
 If bonustimer=800 Then bonuson=True bonustimer=0
 If bonuson=True Then
 For b.bonus = Each bonus
  DrawImage (sprites),b\bonushorpos,b\bonusverpos,b\b_spritepage
  b\bonusverpos=b\bonusverpos+1
  ;b\bonusnorpos=1
 Next
EndIf
End Function

;////////////////////////////////////////////////////
;/ Function to check for collision with BONUS items /
;////////////////////////////////////////////////////
Function bonus_and_man_collision()
 For b.bonus = Each bonus
  If ImagesCollide(sprites,horpos,verpos,0,sprites,b\bonushorpos,b\bonusverpos,0) Then
  Delete b
  score=score+100
  bonuson=False
  launchbonus()
  bonustimer=0 
  EndIf
 Next
End Function

;////////////////////////////////////////////////////
;/ Function to check collision of bonus & the floor /
;////////////////////////////////////////////////////
Function bonus_and_ledges_collision()
 For b.bonus = Each bonus
  If ImageRectCollide(sprites,b\bonushorpos,b\bonusverpos,frame1,345,300,100,26)=1 Then
   b\bonusverpos=(305-64)
  EndIf
  If ImageRectCollide(sprites,b\bonushorpos,b\bonusverpos,frame1,000,575,800,26)=1 Then
   b\bonusverpos=(579-64)
  EndIf
  Next
End Function

;//////////////////////////////////////
;/ Function to initialise the Bullets /
;//////////////////////////////////////
Function launchbullet()
 f.fire = New fire
 f\fireverpos = verpos+32
 f\firehorpos = horpos
; f\f_spritepage = 26 ;46 ; 25 when on 46 when off
End Function

;/////////////////////////////////////
;/ Function to move fire the bullets /
;/////////////////////////////////////
Function updatebullet()
If fire=False Then
For f.fire = Each fire		;loop thro all of the meator variables
   f\firehorpos=horpos
   f\fireverpos=verpos+32
Next
EndIf
If fire=True Then
 For f.fire = Each fire
  If man_left=True And offscreen=False Then fireleft=True
  If fireleft=True Then f\firehorpos=f\firehorpos-5 offscreen=True ;add a trip to stop bullet changing directions with jetman !
  If man_right=True And offscreen=False Then fireright=True
  If fireright=True Then f\firehorpos=f\firehorpos+5 offscreen=True
  If f\firehorpos<=-80 Or f\firehorpos>=800 Then ;if bullet goes off screen reset it !
   f\f_spritepage=46
   f\firehorpos=horpos				;randomly reposition in the verticle position
   f\fireverpos=verpos+32
;;   ;Delete f
   fire=False
   fireleft=False 
   fireright=False 
   offscreen=False
  EndIf
 DrawImage (bullet),f\firehorpos,f\fireverpos
 For m.meator = Each meator		;loop thro all of the meator variables
   If ImagesCollide(bullet,f\firehorpos,f\fireverpos,0,sprites,m\mhorpos,m\mverpos,0) Then
    fire=False fireleft=False fireright=False offscreen=False
   If MilliSecs()>meator_bullet_timer + 50 Then
    meator_bullet_timer=MilliSecs()
    m\m_spritepage=m\m_spritepage-1
   EndIf
    If m\m_spritepage=<16 Then 
    Delete m 
    launchmeators()				;launch a new meator
    PlaySound (hit)
    score=score+50
   EndIf
   EndIf
  Next
Next
EndIf
End Function

;////////////////////////////////////////////////////////
;/ Function to remove any stray partly exploded meators /
;////////////////////////////////////////////////////////
Function remove_stray_meators()
 For m.meator = Each meator
 If m\m_spritepage>16 And m\m_spritepage<19
  If MilliSecs()>meator_bullet_timer + 50 Then
   meator_bullet_timer=MilliSecs()
   m\m_spritepage=m\m_spritepage-1
  EndIf
    If m\m_spritepage=16 Then 
    Delete m
    PlaySound (hit)
    launchmeators()
    score=score+50
  EndIf
 EndIf
Next
End Function