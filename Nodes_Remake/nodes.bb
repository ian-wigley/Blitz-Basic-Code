;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;  Nodes of Yesod Remake   ;
;           2d             ;
;   Blitz basic version    ; 
;  written by Ian Wigley   ;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;-------------------------------------- set globals ---------------------------------------------
Global fish_reset=False
Global die_anim=False
Global strange=False
Global launched=False
Global deleted=False
Global temp_verpos=0
Global jump_up=False
Global jump=False
Global jump_flag=False
Global summersault_jump_flag=False
Global jump_clear=True
Global jump_stop=True
Global temp_ver_switch=False
Global switch_right=False ; switch variable used in walking animation timer
Global switch_left=False  ; as above !
Global fntariala,fntarialb,fntimpact
Global f1=True
Global f2=False
Global f3=False
Global b_page=0
Global verpos=400
Global horpos=150
Global verpos1=580-64
Global spaceman_spritepage=0
Global jumpright_spritepage=19
Global jumpupleft_spritepage=73
Global man_Left=False, man_Right=True
Global lives=3 
Global lost_live=False
Global falling_counter=0
Global game_on=False, game_off=False
Global upper_rock_counter_0=0
Global upper_rock_counter_1=1
Global upper_rock_counter_2=2
Global upper_rock_counter_3=3
Global upper_rock_counter_4=2
Global upper_rock_counter_5=1
Global upper_rock_counter_6=3
Global upper_rock_counter_7=0
Global lower_rock_counter_0=0;5
Global lower_rock_counter_1=0;6
Global lower_rock_counter_2=0;7
Global lower_rock_counter_3=0;7
Global lower_rock_counter_4=0;5
Global lower_rock_counter_5=0;6
Global lower_rock_counter_6=0;7
Global lower_rock_counter_7=0;6
Global left_wall_0_on=False
Global right_wall_0_on=False
Global left_wall_counter=10
Global right_wall_counter=11
Global ledge_0=False
Global ledge_1=False
Global ledge_2=False
Global ledge_3=False
Global ledge_4=False
Global ledge_5=False
Global ledge_6=False
Global ledge_0_x=0
Global ledge_0_y=0
Global ledge_1_x=0
Global ledge_1_y=0
Global ledge_2_x=0
Global ledge_2_y=0
Global ledge_3_x=0
Global ledge_3_y=0
Global ledge_4_x=0
Global ledge_4_y=0
Global ledge_5_x=0
Global ledge_5_y=0
Global ledge_6_x=0
Global ledge_6_y=0
Global green_ledge_0=False
Global green_ledge_1=False
Global green_ledge_2=False
Global green_ledge_3=False
Global g_ledge_0_x=0
Global g_ledge_0_y=0
Global g_ledge_1_x=0
Global g_ledge_1_y=0
Global g_ledge_2_x=0
Global g_ledge_2_y=0
Global g_ledge_3_x=0
Global g_ledge_3_y=0
Global p_ledge_0_x=0
Global p_ledge_0_y=0
Global p_ledge_1_x=0
Global p_ledge_1_y=0
Global p_ledge_2_x=0
Global p_ledge_2_y=0
Global p_ledge_3_x=0
Global p_ledge_3_y=0
Global p_ledge_4_x=0
Global p_ledge_4_y=0
Global pole_ledges=False
Global small_pole_ledges=False
Global mid_pole_ledges  =False
Global tall_pole_ledges=False
Global extra_tall_pole_ledges=False
Global floor_on=False
Global Part_floor_left_on=False
Global Part_floor_mid_on=False
Global Part_floor_right_on=False
Global hole_collision=False
Global below_moon_surface=False
Global hole1=False
Global hole2=False
Global mound_1=False
Global mound_2=False
Global ledge_collision=False
Global roof_rocks=False
Global alchiem1=False	;Square
Global alchiem2=False	;Triangle
Global alchiem3=False	;Circle
Global alchiem4=False	;Diamond
Global alchiem1_x=0
Global alchiem1_y=0
Global alchiem2_x=0
Global alchiem2_y=0
Global alchiem3_x=0
Global alchiem3_y=0
Global alchiem4_x=0
Global alchiem4_y=0
Global alchiem_count1=False
Global alchiem_count2=False
Global alchiem_count3=False
Global alchiem_count4=False
Global alchiem_count5=False
Global alchiem_count6=False
Global alchiem_count7=False
Global alchiem_count8=False
Global alchiem_counter=0
Global rocket_x=0
Global rocket_screen=0

;-------------------------------------- Menu Arrows ---------------------------

Global arrow_verpos=85;80
Global arrow_down=False
Global arrow_up=False
Global left_arrow=380  
Global right_arrow=610;600;560
Global switch_arrow=True
Global switch_right_arrow_right=True

;--------------------------------------- AI Globals ---------------------------

Global ene_1_switchdown=True	; Spring Bear
Global ene_1_switchup=False
Global ene_1_switchleft=False
Global ene_1_switchright=True
Global ene_7_switchdown=True	; Fish
Global ene_7_switchup=False
Global ene_7_switchleft=False
Global ene_7_switchright=True
Global ene_8_switchleft=False	; Blue Bear
Global ene_8_switchright=True
Global ene_9_switchleft=False
Global ene_9_switchright=True
Global enemy_1=False
Global enemy_2=False
Global enemy_3=False
Global enemy_4=False
Global enemy_5=False
Global enemy_6=False
Global enemy_7=False
Global enemy_8=False
Global enemy_9=False
Global enemy_10=False
Global enemy_11=False
Global enemy_switcher=False
Global ene_7_spritepage=118
Global ene_8_spritepage=76
Global flag_1=False		; Used to correct Start Spritepage on Blue Bear walking animation 
Global flag_2=False		; Used on the fish !
Global explosion=176

;------------------------------------------------------------------------------
Global screen_counter=6
Global next_screen=False
Global prev_screen=False
Global offscreen=False

Global underground_screen_counter=0

Global underground_down_screen_counter=0
Global underground_up_screen_counter=0
Global underground_left_screen_counter=0
Global underground_right_screen_counter=0
;--------------------------------------------------------------------

Global underground_switch=False
Global falling=False

;--------------------------------- debug globals ----------------------------------------
Global u_screen_log=0
Global debugger=False
Global earth_debug=0
;------------------------------------ timers -------------------------------------------------

Global enemy_timer=0
Global dying_timer=0
Global jumping_timer=0
Global jumpingup_timer=0
Global walking_timer=0
Global earth_timer=0
Global spaceman_timer=0
Global bonustimer=0
Global Level_Timer
Global timer=000000
Global bitmap=True
Global key1=False
Global key2=False
Global walking_left_timer=0, walking_right_timer=0
Global meator_bullet_timer=0, meator_ledges_timer=0

;-------------------------------------- set types ---------------------------------------------


Global earth_spritepage= 247
Global earthverpos=	600	;vertical position
Global earthhorpos= 60

;define spaceman type
Type spaceman
	Field spacemanverpos		;vertical position
	Field spacemanhorpos		;horizontal position
	Field spaceman_spritepage	;spaceman sprite image
	Field spaceman_r_dying_spritepage
	Field spaceman_l_dying_spritepage
	Field jumpright_spritepage  ;spaceman jump right sprite image
	Field jumpleft_spritepage 
	Field jumpupright_spritepage 
	Field jumpupleft_spritepage
End Type

Type star
	Field starverpos
	Field starhorpos
	Field star_spritepage
End Type	

Global ene_1_verpos=200
Global ene_1_horpos=200
Global ene_2_verpos=250
Global ene_2_horpos=250
Global ene_3_verpos=300
Global ene_3_horpos=300
Global ene_7_verpos=400
Global ene_7_horpos=380
Global ene_8_horpos=100


;**************************************************************************************
; define Enenmy type
Type enemy
	Field enemy_1_verpos
	Field enemy_1_horpos
	Field enemy_1_spritepage
	Field enemy_2_verpos
	Field enemy_2_horpos
	Field enemy_2_spritepage
	Field enemy_3_verpos
	Field enemy_3_horpos
	Field enemy_3_spritepage
	Field enemy_4_verpos
	Field enemy_4_horpos
	Field enemy_4_spritepage
	Field enemy_5_verpos
	Field enemy_5_horpos
	Field enemy_5_spritepage
	Field enemy_6_verpos
	Field enemy_6_horpos
	Field enemy_6_spritepage
	Field enemy_7_verpos
	Field enemy_7_horpos
	Field enemy_7_spritepage
	Field enemy_8_verpos
	Field enemy_8_horpos
	Field enemy_8_spritepage
	Field enemy_9_verpos
	Field enemy_9_horpos
	Field enemy_9_spritepage
	Field enemy_10_verpos
	Field enemy_10_horpos
	Field enemy_10_spritepage
End Type


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

;-------------------------------- set consts & load graphics ---------------------------------------

Const ledge_0_spr=160  ;ledges 0-2 are small
Const ledge_1_spr=160
Const ledge_2_spr=160

Const ledge_3_spr=161  ;ledges 3-6 are big
Const ledge_4_spr=161
Const ledge_5_spr=161
Const ledge_6_spr=161

Const SCREEN_WIDTH = 800
Const SCREEN_HEIGHT = 600

Graphics SCREEN_WIDTH,SCREEN_HEIGHT,16,2 ; 1 - max window size : 2 - windowed
SetBuffer BackBuffer()

Cls

Global sprites = LoadAnimImage("graphics\sprites.png",64,69,0,260)
Global moon_rocks = LoadAnimImage("graphics\rocks_again.png",100,117,0,28)
Global front_screen = LoadImage("graphics\nodes_front_screen.png")
Global Lazer   = LoadSound("graphics\fire.wav")
Global hit     = LoadSound("graphics\hit.wav")
Global died    = LoadSound("graphics\died.wav")
Global music   = PlayMusic("graphics\overgrown.mod")

fntariala=LoadFont("arial",24,True,False,False)
fntarialb=LoadFont("arial",12,True,False,False)
fntimpact=LoadFont("impact",36,True,False,False)

While Not KeyHit(1)
Cls

title_functions()
game_functions()

Flip
Wend
FreeFont fntariala
FreeFont fntarialb
FreeFont fntimpact
End

;////////////////////////////////////
;/ Title screen functions and stuff /
;////////////////////////////////////
Function title_functions()
If game_on=False
If key1=False And key2=False DrawImage(front_screen),0,0
SetFont fntimpact                

If key1=False
Text 295,020,Mid$("NODES OF YESOD REMAKE",True)
Text 480,100,Mid$("   Start    ",True)
Text 450,140,Mid$("Instructions",True)
Text 455,180,Mid$("Define Keys ",True)
Text 490,220,Mid$("   Exit     ",True)
EndIf

If key1=True
Cls
Text 310,020,Mid$("INSTRUCTIONS",True)
Text 100,100,Mid$("Using the arrow keys guide the man around  ",True)
Text 100,140,Mid$("around both above & below the moon surafce ",True)
Text 100,180,Mid$("Collect all of the Alchiems and make your  ",True)
Text 100,220,Mid$("            way to the exit                ",True)
Text 080,300,Mid$("Press the Return Key to go back to the main menu",True)
If KeyDown(28) Then key1=False
EndIf

If key2=True
Cls
Text 310,020,Mid$("DEFINE KEYS",True)
Text 080,300,Mid$("Press the Return Key to go back to the main menu",True)
If KeyDown(28) Then key2=False
EndIf

If key1=False And key2=False

DrawImage(sprites),left_arrow,arrow_verpos,150 
DrawImage(sprites),right_arrow,arrow_verpos,151

If switch_arrow=True And Left_arrow<390 Then Left_arrow=Left_arrow+1 right_arrow=right_arrow-1

If Left_arrow=>390 Then switch_arrow=False

If switch_arrow=False And Left_arrow>370 Then Left_arrow=Left_arrow-1 right_arrow=right_arrow+1
If Left_arrow=<370 Then switch_arrow=True

If KeyDown(208)	Then arrow_down=True arrow_up=False ;down arrow
If Not KeyDown(208)	Then arrow_down=False; arrow_up=False ;down arrow
If KeyDown(200)	Then arrow_up=True arrow_down=False	;up arrow
If Not KeyDown(200) Then arrow_up=False

If arrow_down=True Then
If MilliSecs()>spaceman_timer + 100 Then 
spaceman_timer=MilliSecs()
arrow_verpos=arrow_verpos+40;30;20
arrow_down=False
If arrow_verpos>85+(3*40) Then arrow_verpos=85+(3*40);220;180
EndIf
EndIf
;If arrow_verpos=120 Then arrow_up=False arrow_down=False
If arrow_up=True Then
If MilliSecs()>spaceman_timer + 100 Then 
spaceman_timer=MilliSecs()
arrow_verpos=arrow_verpos-40;30;0
arrow_up=False
If arrow_verpos<85 Then arrow_verpos=85
;If arrow_verpos<100 Then arrow_verpos=80
EndIf
EndIf
EndIf
If KeyDown(57) And arrow_verpos=85+40 Then key1=True
If KeyDown(57) And arrow_verpos=85+80 Then key2=True
If KeyDown(57) And arrow_verpos=85+120 Then key3=True 
If KeyDown(57) And arrow_verpos=85 Then
lives=3					;set the amount of lives to 3
launch_space_man()
 game_on=True 
 key1=False
 key2=False
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
animate_rocket()
draw_n_test_sprites()
keyboard()
animate_space_man()
Screen_increase()
Screen_decrease()
man_and_floor_collision()
man_and_hole_collision()
man_and_ledge0_collision_check()
man_and_ledge1_collision_check()
man_and_ledge2_collision_check()
man_and_ledge3_collision_check()
man_and_ledge4_collision_check()
man_and_ledge5_collision_check()
man_and_ledge6_collision_check()
man_and_alchiem_collision_check()
man_and_g_ledge_0_collision_check()
man_and_g_ledge_1_collision_check()
man_and_poleledge_collision_check()
man_and_floor_collision()
man_and_part_floor_collision()
move_enemies()
above_or_below_moon_surface()
are_we_dead_yet()
debug()

timer=timer+1

End If
End Function

;---------------------------------------------------------------------------------------------------

;//////////////////////////////
;/ Draws all in game graphics /
;//////////////////////////////

Function draw_n_test_sprites()

;DrawImage(sprites),600,60,154	;Earth !
If below_moon_surface=False Then

Color 100,100,100
Text 50,20,Mid$(".",True);1
Color 200,200,100
Text 350,30,Mid$(".",True);2
Color 200,100,100
Text 670,40,Mid$(".",True);3
Color 200,100,100
Text 90,50,Mid$(".",True);4
Color 200,100,100
Text 450,60,Mid$(".",True);5

Color 200,100,100
Text 750,70,Mid$(".",True);6
Color 200,100,100
Text 75,80,Mid$(".",True);7
Color 200,100,100
Text 190,110,Mid$(".",True);8
Color 200,100,100
Text 670,150,Mid$(".",True);9

;DrawImage(sprites),400,80,169 ; draw star

If rocket_screen=screen_counter Then
 DrawImage(sprites),rocket_x,118,188	;Rocket !
EndIf

DrawImage(moon_rocks),000,170,upper_rock_counter_0
DrawImage(moon_rocks),100,170,upper_rock_counter_1
DrawImage(moon_rocks),200,170,upper_rock_counter_2
DrawImage(moon_rocks),300,170,upper_rock_counter_3
DrawImage(moon_rocks),400,170,upper_rock_counter_4
DrawImage(moon_rocks),500,170,upper_rock_counter_5
DrawImage(moon_rocks),600,170,upper_rock_counter_6
DrawImage(moon_rocks),700,170,upper_rock_counter_7

;DrawImage(sprites),horpos,verpos,b_page

If mound_1=True Then
DrawImage(sprites),200,300,171;230,171	;hole
DrawImage(sprites),264,300,172;172
EndIf

If mound_2=True Then
DrawImage(sprites),400,330,171	;hole
DrawImage(sprites),464,330,172
EndIf

If hole1=True Then				; draw holes
DrawImage(sprites),280,430,152	;hole
DrawImage(sprites),344,430,153
EndIf

If hole2=True Then
DrawImage(sprites),480,430,152	;hole
DrawImage(sprites),544,430,153
EndIf

DrawImage(moon_rocks),000,430,lower_rock_counter_0	;477
DrawImage(moon_rocks),100,430,lower_rock_counter_1
DrawImage(moon_rocks),200,430,lower_rock_counter_2
DrawImage(moon_rocks),300,430,lower_rock_counter_3
DrawImage(moon_rocks),400,430,lower_rock_counter_4
DrawImage(moon_rocks),500,430,lower_rock_counter_5
DrawImage(moon_rocks),600,430,lower_rock_counter_6
DrawImage(moon_rocks),700,430,lower_rock_counter_7
EndIf


If below_moon_surface=True
If left_wall_0_on=True Then
DrawImage(moon_rocks),100,060,left_wall_counter
DrawImage(moon_rocks),100,152,10
DrawImage(moon_rocks),100,244,10
DrawImage(moon_rocks),100,336,10
DrawImage(moon_rocks),100,430,10
EndIf

If right_wall_0_on=True Then 
DrawImage(moon_rocks),700,060,right_wall_counter
DrawImage(moon_rocks),700,152,11
DrawImage(moon_rocks),700,244,11
DrawImage(moon_rocks),700,336,11
DrawImage(moon_rocks),700,430,11
EndIf
If ledge_0=True
DrawImage(sprites),ledge_0_x,ledge_0_y,ledge_0_spr
EndIf
If ledge_1=True
DrawImage(sprites),ledge_1_x,ledge_1_y,ledge_1_spr
EndIf
If ledge_2=True
DrawImage(sprites),ledge_2_x,ledge_2_y,ledge_2_spr
EndIf
If ledge_3=True
DrawImage(sprites),ledge_3_x,ledge_3_y,ledge_3_spr
EndIf
If ledge_4=True
DrawImage(sprites),ledge_4_x,ledge_4_y,ledge_4_spr
EndIf
If ledge_5=True
DrawImage(sprites),ledge_5_x,ledge_5_y,ledge_5_spr
EndIf
If ledge_6=True
DrawImage(sprites),ledge_6_x,ledge_6_y,ledge_6_spr
EndIf

DrawImage(sprites),g_ledge_0_x,g_ledge_0_y,162
DrawImage(sprites),g_ledge_2_x,g_ledge_2_y,162
DrawImage(sprites),g_ledge_1_x,g_ledge_1_y,163
DrawImage(sprites),g_ledge_3_x,g_ledge_3_y,163


If roof_rocks=True Then
; DrawImage(moon_rocks),113,246,20
 DrawImage(moon_rocks),113,40,20
 DrawImage(moon_rocks),213,40,21
 DrawImage(moon_rocks),313,40,22
 DrawImage(moon_rocks),413,40,23
 DrawImage(moon_rocks),513,40,24
 DrawImage(moon_rocks),613,40,21
EndIf
	
If floor_on=True Then
 DrawImage(moon_rocks),113,446,15
 DrawImage(moon_rocks),213,446,15
 DrawImage(moon_rocks),313,446,15
 DrawImage(moon_rocks),413,446,15
 DrawImage(moon_rocks),513,446,15
 DrawImage(moon_rocks),613,446,15
EndIf

If Part_floor_left_on=True Then ;And Part_floor_right_on=True Then
 DrawImage(moon_rocks),113,446,15
 DrawImage(moon_rocks),213,446,15
EndIf
If Part_floor_mid_on=True Then
 DrawImage(moon_rocks),313,446,15
 DrawImage(moon_rocks),413,446,15
EndIf
If Part_floor_right_on=True Then
 ; DrawImage(moon_rocks),313,446,15
 ; DrawImage(moon_rocks),413,446,15
 DrawImage(moon_rocks),513,446,15
 DrawImage(moon_rocks),613,446,15
EndIf


If alchiem1=True Then
 DrawImage(sprites),alchiem1_x,alchiem1_y,164
EndIf

If alchiem2=True Then
 DrawImage(sprites),alchiem2_x,alchiem2_y,165
EndIf

If alchiem3=True Then
 DrawImage(sprites),alchiem3_x,alchiem3_y,166
EndIf

If alchiem4=True Then
 DrawImage(sprites),alchiem4_x,alchiem4_y,167
EndIf

If alchiem5=True Then
 DrawImage(sprites),alchiem5_x,alchiem5_y,167
EndIf

If alchiem6=True Then
 DrawImage(sprites),alchiem6_x,alchiem6_y,167
EndIf

If alchiem7=True Then
 DrawImage(sprites),alchiem7_x,alchiem7_y,167
EndIf

If alchiem8=True Then
 DrawImage(sprites),alchiem8_x,alchiem8_y,167
EndIf

If small_pole_ledges=True Then
 DrawImage(moon_rocks),p_ledge_3_x,p_ledge_3_y,14
EndIf

If mid_pole_ledges=True Then
; DrawImage(moon_rocks),p_ledge_0_x,p_ledge_0_y,12
 DrawImage(moon_rocks),p_ledge_2_x,p_ledge_2_y,12
EndIf

If tall_pole_ledges=True Then
 DrawImage(moon_rocks),p_ledge_0_x,p_ledge_0_y,12
 DrawImage(moon_rocks),p_ledge_1_x,p_ledge_1_y,13
; DrawImage(moon_rocks),p_ledge_2_x,p_ledge_2_y,12
EndIf

If extra_tall_pole_ledges=True Then
 DrawImage(moon_rocks),p_ledge_0_x,p_ledge_0_y,12
 DrawImage(moon_rocks),p_ledge_1_x,p_ledge_1_y,13
 DrawImage(moon_rocks),p_ledge_4_x,p_ledge_4_y,13
EndIf
EndIf

;DrawImage(panel),30,550 
DrawImage(sprites),30,534,190
DrawImage(sprites),76,534,191
DrawImage(sprites),140,534,192
DrawImage(sprites),204,534,193
DrawImage(sprites),356,534,194
DrawImage(sprites),420,534,195
DrawImage(sprites),570,534,196
DrawImage(sprites),634,534,197
DrawImage(sprites),698,534,198

If alchiem_counter=1
DrawImage(sprites),83,531,199
EndIf
If alchiem_counter=2
DrawImage(sprites),83,531,199
DrawImage(sprites),99,531,199
EndIf
If alchiem_counter=3
DrawImage(sprites),83,531,199
DrawImage(sprites),99,531,199
DrawImage(sprites),115,531,199
EndIf
If alchiem_counter=4
DrawImage(sprites),83,531,199
DrawImage(sprites),99,531,199
DrawImage(sprites),115,531,199
DrawImage(sprites),131,531,199
EndIf
If alchiem_counter=5
DrawImage(sprites),83,531,199
DrawImage(sprites),99,531,199
DrawImage(sprites),115,531,199
DrawImage(sprites),131,531,199
DrawImage(sprites),147,531,199
EndIf
If alchiem_counter=6
DrawImage(sprites),83,531,199
DrawImage(sprites),99,531,199
DrawImage(sprites),115,531,199
DrawImage(sprites),131,531,199
DrawImage(sprites),147,531,199
DrawImage(sprites),163,531,199
EndIf
If alchiem_counter=7
DrawImage(sprites),83,531,199
DrawImage(sprites),99,531,199
DrawImage(sprites),115,531,199
DrawImage(sprites),131,531,199
DrawImage(sprites),147,531,199
DrawImage(sprites),163,531,199
DrawImage(sprites),179,531,199
EndIf
If alchiem_counter=8
DrawImage(sprites),83,531,199
DrawImage(sprites),99,531,199
DrawImage(sprites),115,531,199
DrawImage(sprites),131,531,199
DrawImage(sprites),147,531,199
DrawImage(sprites),163,531,199
DrawImage(sprites),179,531,199
DrawImage(sprites),195,531,199
EndIf


If below_moon_surface=False And horpos=<0 Then horpos=horpos+2 prev_screen=True
If below_moon_surface=False And horpos=>738 Then horpos=horpos-2 next_screen=True
If below_moon_surface=True And left_wall_0_on=True And horpos=<116 Then horpos=117 ;120
;If below_moon_surface=True And horpos=<116 Then horpos=117
If below_moon_surface=True And right_wall_0_on=True And horpos=>650 Then horpos=650

If below_moon_surface=True Then
 If left_wall_0_on=False And horpos=<118 Then ;And left_switch=False Then 
	screen_counter=screen_counter-1 
	horpos=648;50 
	enemy_switcher=True 
	launched=False 
	delete_enemies();change enemy on screen flip
 EndIf

 If right_wall_0_on=False And horpos=>650 Then;And left_switch=True Then 
	screen_counter=screen_counter+1
	horpos=120
	enemy_switcher=True
	launched=False
	delete_enemies();change enemy on screen flip
 EndIf

EndIf
End Function

;///////////////////////////
;/ Display score,lives etc /
;///////////////////////////
Function display_text()
SetFont fntariala                       
Text 424,557,Mid$(" "+lives,True) 				;/vertical, /horizontal
Text 500,557,Mid$("Screen "+u_screen_log,True)             ;display screen number for beta testing
Text 625,557,Mid$("00:00:0"+timer,True)
SetFont fntarialb
End Function

;//////////////
;/ Debug text /
;//////////////
Function debug()
If debugger=True
Text 000,010,Mid$("next_screen    "+next_screen,True) ;next_screen=False
Text 250,010,Mid$("upper_rock_counter"+upper_rock_counter,True)
Text 500,010,Mid$("enemy_1 "+enemy_1,True)
Text 700,010,Mid$("left_wall_0_on "+left_wall_0_on,True)

Text 000,020,Mid$("temp_verpos    "+temp_verpos,True)
Text 250,020,Mid$("lower_rock_counter"+lower_rock_counter,True)
Text 500,020,Mid$("enemy_2 "+enemy_2,True)
Text 700,020,Mid$("falling_counter "+falling_counter,True)

Text 000,030,Mid$("verpos         "+verpos,True)
Text 250,030,Mid$("summersault_jump_flag"+summersault_jump_flag,True)
Text 500,030,Mid$("enemy_3 "+enemy_3,True)
Text 700,030,Mid$("jump_up "+jump_up,True)

Text 000,040,Mid$("jump flag      "+jump_flag,True)
Text 250,040,Mid$("underground_down_screen_counter"+underground_down_screen_counter,True)
Text 500,040,Mid$("enemy_4 "+enemy_4,True)
Text 700,040,Mid$("die_anim "+die_anim,True)

Text 000,050,Mid$("jump           "+jump,True)
Text 250,050,Mid$("underground_up_screen_counter"+underground_up_screen_counter,True)
Text 500,050,Mid$("enemy_5 "+enemy_5,True)
Text 700,050,Mid$("lost_live "+lost_live,True)

Text 000,060,Mid$("horpos         "+horpos,True)
Text 250,060,Mid$("underground_left_screen_counter"+underground_left_screen_counter,True)
Text 500,060,Mid$("enemy_6 "+enemy_6,True)
Text 700,060,Mid$("strange "+strange,True)

Text 000,070,Mid$("man_left       "+man_left,True)
Text 250,070,Mid$("underground_right_screen_counter"+underground_right_screen_counter,True)
Text 500,070,Mid$("enemy_7 "+enemy_7,True)
Text 700,070,Mid$("earth_debug = "+earth_debug,True)

Text 000,080,Mid$("man_right      "+man_right,True)
Text 250,080,Mid$("underground_screen_counter"+undergound_screen_counter,True)
Text 500,080,Mid$("enemy_8 "+enemy_8,True)
;Text 650,080,Mid$("facing_wrong_way_flag "+facing_wrong_way_flag,True)

Text 000,090,Mid$("lives          "+lives,True)
Text 250,090,Mid$("falling"+falling,True)
Text 500,090,Mid$("enemy_9 "+enemy_9,True)
;Text 000,100,Mid$("screen0        "+screen0,True)
Text 250,100,Mid$("floor_on       "+floor_on,True)
Text 500,100,Mid$("enemy_10 "+enemy_10,True)
Text 000,110,Mid$("walking        "+walking,True)
Text 250,110,Mid$("left_wall_0_on "+left_wall_0_on,True)
Text 000,120,Mid$("up             "+up,True)
Text 250,120,Mid$("right_wall_0_on "+right_wall_0_on,True)
Text 000,130,Mid$("down           "+down,True)
Text 250,130,Mid$("u_screen= "+u_screen_log,True)
Text 000,140,Mid$("walk right     "+switch_right,True)
Text 250,140,Mid$("pole_ledges"+pole_ledges,True)
Text 500,140,Mid$("enemy_blue_bear"+enemy_blue_bear,True)
Text 000,150,Mid$("walk left      "+switch_left,True)
Text 250,150,Mid$("mid_pole_ledges"+mid_pole_ledges,True)
Text 500,150,Mid$("enemy_bird"+enemy_bird,True)
Text 700,150,Mid$("ene_7_horpos "+ene_7_horpos,True)
Text 000,160,Mid$("screen_counter "+screen_counter,True)
Text 250,160,Mid$("ene_1_verpos"+ene_1_verpos,True)
Text 500,160,Mid$("ene_1_switchup"+ene_1_switchup,True)
Text 700,160,Mid$("ene_7_verpos "+ene_7_verpos,True)
Text 000,170,Mid$("hole_collision "+hole_collision,True)
Text 250,170,Mid$("ene_1_horpos"+ene_1_horpos,True)
Text 500,170,Mid$("mound_1"+mound_1,True)
Text 000,180,Mid$("spaceman_spritepage "+spaceman_spritepage,True)
Text 250,180,Mid$("alchiem_counter"+alchiem_counter,True)
Text 500,180,Mid$("ene_8_spritepage"+ene_8_spritepage,True)
Text 700,180,Mid$("launched"+launched,True)

If fish_reset=True Then
	ene_7_verpos=400;300
	ene_7_horpos=380;300
	fish_reset=False
EndIf

EndIf
End Function

;///////////////////////
;/ Keyboard function ! /
;///////////////////////
Function keyboard ()

If KeyDown(2) And below_moon_surface=False Then screen_counter=0
If KeyDown(3) And below_moon_surface=False Then screen_counter=3
If KeyDown(4) And below_moon_surface=False Then screen_counter=4
If KeyDown(5) And below_moon_surface=False Then screen_counter=8
If KeyDown(6) And below_moon_surface=False Then screen_counter=10
If KeyDown(7) And below_moon_surface=False Then screen_counter=13

If KeyDown(29) Then below_moon_surface=False verpos=400 falling=False underground_down_screen_counter=0 floor_on=False delete_enemies();ctrl key

If KeyDown(59) debugger=True
If KeyDown(60) debugger=False
If KeyDown(61) fish_reset=True

If KeyDown(56) And below_moon_surface=True And falling=False Then jump_up=True ; Jump activated

If KeyDown(56) And KeyDown(203) And falling=False Then jump=True jump_up=False; Jump activated
If KeyDown(56) And KeyDown(205) And falling=False Then jump=True jump_up=False; Jump activated

If KeyDown(203) And jump=False And falling=False Then horpos=horpos-3 man_Left=True man_right=False switch_left=True ;walking=True

;If walking=True And KeyDown(203) Then horpos=horpos-1 man_Left=True switch_left=True switch_right=False;s_left=s_left-1

If KeyDown(205) And jump=False And falling=False Then horpos=horpos+3 man_Right=True man_left=False switch_right=True ;walking=True

;If walking=True And KeyDown(205) Then horpos=horpos+1 man_Right=True switch_right=True ;s_right=s_right+1

If Not KeyDown(205) Then switch_right=False ; If the right arrow is not pressed stop walking animation !
If Not KeyDown(203) Then switch_left=False ;  If the left arrow is not pressed stop walking animation !

End Function

;///////////////////////
;/ Move to next screen /
;///////////////////////
Function Screen_increase()

If below_moon_surface=False  

;If next_screen=True And screen_counter<=14 Then
 If next_screen=True And screen_counter<=15 Then 
	screen_counter=screen_counter+1 
	next_screen=False
	horpos=10
 EndIf
;If screen_counter>14 Then	
 If screen_counter>15 Then 
	screen_counter=0
	horpos=10
 EndIf

undergound_down_screen_counter=0

EndIf

If below_moon_surface=True

; If underground_switch=True Then verpos=120 underground_switch=False

  If jump = True And verpos <=060 And underground_down_screen_counter=0 Then
	underground_down_screen_counter=0
	below_moon_surface=False
	floor_on=False
	verpos=325
	delete_enemies()
	launched=False
Else

  If jump = True And verpos <=060 And underground_down_screen_counter>=1 Then 
	underground_down_screen_counter=underground_down_screen_counter-1
 	verpos=380
	delete_enemies()
	launched=False
 EndIf

 If falling=True And verpos>=480 Then
	;undergound_screen_counter=undergound_screen_counter+1
	underground_down_screen_counter=underground_down_screen_counter+1
 	verpos=080
	delete_enemies()	
	launched=False
	
;	falling_counter=verpos;=underground_down_screen_counter
 EndIf

 If underground_down_screen_counter=3 Then underground_down_screen_counter=3

 If underground_switch=True Then verpos=120 underground_switch=False

screen_selector()
EndIf

; If below_moon_surface=False And horpos=<0 Then horpos=horpos+2 prev_screen=True
; If right_wall_0_on=False And horpos=>650 Then 
;	screen_counter=screen_counter+1 horpos=120 enemy_switcher=True launched=False delete_enemies();change enemy on screen flip
; EndIf

EndIf
End Function

;////////////////////////////////
;/ Move back to previous screen /
;////////////////////////////////
Function Screen_decrease()
If below_moon_surface=False

 If prev_screen=True And screen_counter>=0 Then 
	screen_counter=screen_counter-1 
	prev_screen=False
	horpos=730
 EndIf

 If screen_counter<0 Then
	screen_counter=15
;	screen_counter=14
	horpos=730
	prev_screen=False
 EndIf

screen_selector()
EndIf

; If below_moon_surface=False And horpos=>738 Then horpos=horpos-2 next_screen=True
; If below_moon_surface=True And left_wall_0_on=False And horpos=<118 Then 
;	screen_counter=screen_counter-1 horpos=650 enemy_switcher=True launched=False delete_enemies();change enemy on screen flip
;EndIf
End Function

;///////////////////
;/ sreen selector /
;//////////////////
Function screen_selector()
If below_moon_surface=False
  Select screen_counter
   Case 0
	low_rocks_0()
	up_rocks_0()
	hole1=True
	hole2=True;False
	mound_1=True
	mound_2=False
   Case 1
	low_rocks_1()
	up_rocks_1()
	hole1=False
	hole2=False
	mound_1=True
	mound_2=True
	mound_2=True ;****************
   Case 2
	low_rocks_2()
	up_rocks_2()
	hole1=False
	hole2=False
	mound_1=True
	mound_2=True
   Case 3
	low_rocks_3()
	up_rocks_3()
	hole1=True
	hole2=False;True
	mound_1=True
	mound_2=False	
   Case 4 
	low_rocks_4()
	up_rocks_4()
	hole1=True
	hole2=True
	mound_1=False
	mound_2=False
   Case 5
	low_rocks_1()
	up_rocks_1()
	hole1=False
	hole2=False
	mound_1=True
	mound_2=True
	mound_3=True ;*********************************
   Case 6
	low_rocks_0()
	up_rocks_0()
	hole1=False;True
	hole2=False
	mound_1=True
	mound_2=True 
   Case 7
	low_rocks_3()
	up_rocks_3()
	hole1=False
	hole2=False
	mound_1=True
	mound_2=False
   Case 8
	low_rocks_4()
	up_rocks_2()
	hole1=True
	hole2=False
	mound_1=True
	mound_2=True
   Case 9 
	low_rocks_1()
	up_rocks_1()
	hole1=False
	hole2=False
	mound_1=True
	mound_2=False
   Case 10
	low_rocks_2()
	up_rocks_4()
	hole1=True
	hole2=False
	mound_1=True
	mound_2=True
   Case 11 
	low_rocks_0()
	up_rocks_0()
	hole1=False
	hole2=False
	mound_1=True
	mound_2=True
   Case 12
	low_rocks_1()
	up_rocks_1()
	mound_1=True
	mound_2=True
	hole1=False
	hole2=False
   Case 13
	low_rocks_3()
	up_rocks_3()
	hole1=True
	hole2=False
	mound_1=True
	mound_2=False
   Case 14
	low_rocks_2()
	up_rocks_2()
	hole1=False
	hole2=False
	mound_1=True
	mound_2=True
   Case 15
	low_rocks_1()
	up_rocks_1()
	hole1=False
	hole2=False
	mound_1=False
	mound_2=True
  End Select
EndIf

 If below_moon_surface=True And screen_counter=0 Then
  Select underground_down_screen_counter
   Case 0                                   ; u_screen_1
	reset_ledges()
	left_wall_0_on=True
	right_wall_0_on=True
	
	ledge_1=True
	ledge_3=True
	ledge_4=True 
	
	ledge_3_x=320
	ledge_3_y=160
	ledge_1_x=500
	ledge_1_y=300
	ledge_4_x=380
	ledge_4_y=400
	enemy_1=True
	enemy_3=True
	enemy_5=True
	launch_enemies()
	animate_enemies()
	u_screen_log=1	
   Case 1                                   ; u_screen_2
	reset_ledges()
	left_wall_0_on=True
	right_wall_0_on=True
	ledge_1=True
	ledge_3=True
	ledge_4=True
	ledge_1_x=200
	ledge_1_y=170
	ledge_3_x=350
	ledge_3_y=350
	ledge_4_x=500
	ledge_4_y=500
	enemy_1=True
	enemy_2=True
	enemy_3=True
	animate_enemies()
	launch_enemies()
	u_screen_log=2
   Case 2                                   ; u_screen_3
	reset_ledges()
	left_wall_0_on=True
	right_wall_0_on=True
	ledge_1=True
	ledge_2=True
	ledge_3=True
	ledge_4=True
	ledge_5=True
	ledge_6=True
	ledge_0_x=600
	ledge_0_y=150
	ledge_3_x=270
	ledge_3_y=200
	ledge_1_x=460
	ledge_1_y=260
 	ledge_2_x=340
 	ledge_2_y=300
	ledge_4_x=150
	ledge_4_y=400
	ledge_5_x=200
	ledge_5_y=400
	ledge_6_x=480
	ledge_6_y=470
	enemy_1=True
	enemy_3=True
	enemy_5=True
	animate_enemies()
	launch_enemies()
	u_screen_log=3
   Case 3                                   ; u_screen_4
	reset_ledges()
	left_wall_0_on=True
	right_wall_0_on=True
	ledge_1=True
	ledge_3=True
	ledge_1_x=320
	ledge_1_y=160
	ledge_3_x=200
	ledge_3_y=300
	floor_on=True
	enemy_3=True
	enemy_4=True
	enemy_10=True	
	launch_enemies()
	animate_enemies()
	u_screen_log=4
  End Select
EndIf

 If below_moon_surface=True And screen_counter=3 Then
  Select underground_down_screen_counter
   Case 0                                   ; u_screen_5
	reset_ledges()
	left_wall_0_on=True
	g_ledge_0_x=620
	g_ledge_0_y=484
	ledge_1=True
	ledge_3=True
	ledge_3_x=320
	ledge_3_y=160
	ledge_1_x=400
	ledge_1_y=380
	u_screen_log=5
	enemy_1=True
	enemy_2=True
	launch_enemies()
	animate_enemies()
   Case 1                                   ; u_screen_6
	reset_ledges()
	left_wall_0_on=True
	ledge_1=True
	ledge_3=True
	ledge_4=True
	ledge_3_x=220
	ledge_3_y=160
	ledge_4_x=500
	ledge_4_y=180
	ledge_1_x=380
	ledge_1_y=330
	floor_on=True
	enemy_5=True
	enemy_6=True
	enemy_7=True
	u_screen_log=6
	launch_enemies()
	animate_enemies()
   Case 2                                   ; u_screen_10
	reset_ledges()
	roof_rocks=True
	left_wall_0_on=True
	p_ledge_2_x=650
	p_ledge_2_y=400
	mid_pole_ledges=True
	floor_on=True
	u_screen_log=10
	enemy_1=True
	enemy_3=True
	launch_enemies()	
	animate_enemies()
	End Select
EndIf

 If below_moon_surface=True And screen_counter=4 Then
  Select underground_down_screen_counter
   Case 0                                    ;u_screen_7
	reset_ledges()
	ledge_1=True
	ledge_3=True
	ledge_1_x=460
	ledge_1_y=260
	ledge_3_x=320
	ledge_3_y=320;440
	Part_floor_left_on=True
	Part_floor_right_on=True
	g_ledge_1_x=310;220
	g_ledge_1_y=494;484
	g_ledge_0_x=460;620
	g_ledge_0_y=494;484
	u_screen_log=7
	enemy_1=True
	launch_enemies()
	animate_enemies()
   Case 1                                    ;u_screen_8
	reset_ledges()
;	partial_roof_rocks=True
	right_wall_0_on=True
	ledge_0=True
	ledge_1=True
	ledge_3=True
	ledge_0_x=300
	ledge_0_y=260
	ledge_1_x=460
	ledge_1_y=260
	ledge_3_x=320
	ledge_3_y=440
	g_ledge_1_x=120
	g_ledge_1_y=484
	u_screen_log=8
	enemy_1=True
	enemy_3=True
	enemy_7=True
	launch_enemies()	
	animate_enemies()
   Case 2                                    ;u_screen_9
	reset_ledges()
	right_wall_0_on=True
	ledge_0=True
	ledge_1=True
	ledge_3=True
	ledge_0_x=460
	ledge_0_y=260
	ledge_1_x=360
	ledge_1_y=260
	ledge_3_x=220
	ledge_3_y=440
	green_ledge_1=True
	g_ledge_1_x=120
	g_ledge_1_y=484
	u_screen_log=9
	enemy_7=True
	enemy_10=True
	launch_enemies()	
	animate_enemies()	
   Case 3                                    ;u_screen_11
	reset_ledges()
	left_wall_0_on=True
	ledge_3=True
	ledge_3_x=320
	ledge_3_y=200
	p_ledge_0_x=165
	p_ledge_0_y=353;2;55;0
	p_ledge_1_x=165 ;long legs
	p_ledge_1_y=400
	p_ledge_2_x=600
	p_ledge_2_y=400
	mid_pole_ledges=True
	tall_pole_ledges=True
;	pole_ledges=True
	floor_on=True
	u_screen_log=11
	enemy_1=True
;	enemy_2=True
;	enemy_3=True
	launch_enemies()
	animate_enemies()
	End Select
EndIf	

 If below_moon_surface=True And screen_counter=5 Then
  Select underground_down_screen_counter
   Case 0                                    ;u_screen_13
	reset_ledges()
	roof_rocks=True
	floor_on=True
	u_screen_log=13
	enemy_1=True
	enemy_3=True
	enemy_8=True
	launch_enemies()
	animate_enemies()
   Case 1                                    ;u_screen_17
	reset_ledges()
	roof_rocks=True
	left_wall_0_on=True
	g_ledge_0_x=620
	g_ledge_0_y=484
	ledge_1=True
	ledge_1_x=390;320
	ledge_1_y=440
;	floor_on=True
	u_screen_log=17
	enemy_5=True
	enemy_6=True
;	enemy_3=True
	launch_enemies()
	animate_enemies()
   Case 2                                    ;u_screen_18
	reset_ledges()
	left_wall_0_on=True
	right_wall_0_on=True
	ledge_3=True
	ledge_3_x=220
	ledge_3_y=240;300;440
	If alchiem_count2=False
	alchiem2_x=400
	alchiem2_y=323;300;400
	alchiem2=True	;Triangle
	EndIf
	p_ledge_0_x=400;165
	p_ledge_0_y=353;2;55;0
	p_ledge_1_x=400;165 ;long legs
	p_ledge_1_y=400
	tall_pole_ledges=True
	floor_on=True
	u_screen_log=18
	enemy_1=True
	enemy_3=True
	launch_enemies()
	animate_enemies()
   Case 3                                    ;u_screen_12
	reset_ledges()
	roof_rocks=True
	right_wall_0_on=True
	If alchiem_count1=False	
	alchiem1_x=320
	alchiem1_y=360
	alchiem1=True	;Square
	EndIf

	ledge_3=True	
	ledge_3_x=320
	ledge_3_y=400
	floor_on=True
	u_screen_log=12
	enemy_1=True
	enemy_2=True
	launch_enemies()
	animate_enemies()
	End Select
EndIf

 If below_moon_surface=True And screen_counter=6 Then
  Select underground_down_screen_counter
   Case 0                                    ;u_screen_14
	reset_ledges()
	roof_rocks=True
	g_ledge_1_x=120
	g_ledge_1_y=494;484
	g_ledge_0_x=620
	g_ledge_0_y=494;484	
	u_screen_log=14
	enemy_1=True
	enemy_3=True
	enemy_5=True
	launch_enemies()
	animate_enemies()
   Case 1                                    ;u_screen_16
	reset_ledges()
	right_wall_0_on=True
	ledge_1=True
	ledge_3=True
	ledge_1_x=260
	ledge_1_y=200;160
	ledge_3_x=420
	ledge_3_y=230;190
	p_ledge_2_x=300;400;650
	p_ledge_2_y=400;400
	mid_pole_ledges=True
;	pole_ledges=True	
	floor_on=True
	u_screen_log=16
	enemy_1=True
	enemy_2=True
	enemy_10=True
	launch_enemies()
	animate_enemies()
	End Select
EndIf

 If below_moon_surface=True And screen_counter=7 Then
  Select underground_down_screen_counter
   Case 0                                    ;u_screen_15
	reset_ledges()
	roof_rocks=True
	right_wall_0_on=True
	u_screen_log=15
	floor_on=True
    enemy_space_dust=True
	enemy_3=True
	enemy_6=True
	enemy_10=True
	launch_enemies()
	animate_enemies()
   Case 1                                    ;u_screen_21
	reset_ledges()
	roof_rocks=True
	left_wall_0_on=True
	ledge_3=True
	ledge_3_x=580
	ledge_3_y=360
	If alchiem_count3=False
	alchiem3_x=180
	alchiem3_y=323
	alchiem3=True	;Circle
	EndIf
	p_ledge_0_x=180
	p_ledge_0_y=353
	p_ledge_1_x=180
	p_ledge_1_y=400
	tall_pole_ledges=True
	p_ledge_3_x=380
	p_ledge_3_y=400
	small_pole_ledges=True	
	floor_on=True
	u_screen_log=21
	enemy_1=True
	enemy_3=True
	launch_enemies()
	animate_enemies()
	End Select
EndIf

 If below_moon_surface=True And screen_counter=8 Then
  Select underground_down_screen_counter
   Case 0                                    ;u_screen_19
	reset_ledges()
	right_wall_0_on=True
	left_wall_0_on=True
	ledge_1=True
	ledge_3=True
	ledge_4=True
	ledge_1_x=460
	ledge_1_y=160
	ledge_3_x=320
	ledge_3_y=190
	ledge_4_x=220
	ledge_4_y=400
	u_screen_log=19
	enemy_1=True
	enemy_2=True
	enemy_3=True
	launch_enemies()
	animate_enemies()
   Case 1                                    ;u_screen_20
	reset_ledges()
	ledge_1=True
	ledge_3=True
	ledge_1_x=260
	ledge_1_y=360;160
	ledge_3_x=420
	ledge_3_y=210
	p_ledge_2_x=580;650
	p_ledge_2_y=400
	mid_pole_ledges=True	
	floor_on=True
	u_screen_log=20
	enemy_3=True
	enemy_8=True
	launch_enemies()
	animate_enemies()
	End Select	
EndIf
 If below_moon_surface=True And screen_counter=9 Then
  Select underground_down_screen_counter
   Case 0                                    ;u_screen_30
	reset_ledges()
	roof_rocks=True
	left_wall_0_on=True
	ledge_1=True
	ledge_3=True
	ledge_1_x=260
	ledge_1_y=160
	ledge_3_x=420
	ledge_3_y=190
	u_screen_log=30
	enemy_5=True
	launch_enemies()
	animate_enemies()
   Case 1                                    ;u_screen_22
	reset_ledges()
	ledge_1=True
	ledge_3=True
	ledge_1_x=260
	ledge_1_y=160
	ledge_3_x=420
	ledge_3_y=190
	p_ledge_3_x=180
	p_ledge_3_y=400
	small_pole_ledges=True
	p_ledge_2_x=400;650
	p_ledge_2_y=400
	mid_pole_ledges=True;tall_pole_ledges=True
	floor_on=True
	u_screen_log=22
	enemy_1=True
	enemy_3=True
	launch_enemies()
	animate_enemies()
	End Select	
EndIf
 If below_moon_surface=True And screen_counter=10 Then
  Select underground_down_screen_counter
   Case 0                                    ;u_screen_31
	reset_ledges()
	right_wall_0_on=True
	ledge_3=True
	ledge_3_x=420
	ledge_3_y=190
	p_ledge_0_x=400
	p_ledge_0_y=353;2
	p_ledge_1_x=400 ;long legs
	p_ledge_1_y=400
	tall_pole_ledges=True
	floor_on=True
	u_screen_log=31
	enemy_1=True
	enemy_3=True
	enemy_4=True
	launch_enemies()
	animate_enemies()
   Case 1                                    ;u_screen_23
	reset_ledges()
	roof_rocks=True
	g_ledge_2_x=340;620
	g_ledge_2_y=494;484
	g_ledge_0_x=620;620
	g_ledge_0_y=494;484
	g_ledge_1_x=120;620
	g_ledge_1_y=494;484
	g_ledge_3_x=400;620
	g_ledge_3_y=494;484
	u_screen_log=23
	enemy_1=True
	enemy_2=True
	enemy_5=True
	launch_enemies()
	animate_enemies()
   Case 2                                    ;u_screen_24
	reset_ledges()
	left_wall_0_on=True
	right_wall_0_on=True
	ledge_1=True
	ledge_3=True
	ledge_1_x=260
	ledge_1_y=160
	ledge_3_x=420
	ledge_3_y=190
	u_screen_log=24
	enemy_1=True
	enemy_2=True
	launch_enemies()
	animate_enemies()
   Case 3                                    ;u_screen_25
	reset_ledges()
	left_wall_0_on=True
	ledge_1=True
	ledge_1_x=160;260
	ledge_1_y=160
	p_ledge_0_x=200;380;480
	p_ledge_0_y=353;352
	p_ledge_1_x=200;380;480 ;long legs
	p_ledge_1_y=400
	tall_pole_ledges=True
	p_ledge_3_x=380
	p_ledge_3_y=400
	small_pole_ledges=True
	floor_on=True
	u_screen_log=25
	enemy_1=True
	enemy_3=True
	launch_enemies()
	animate_enemies()	
	End Select
EndIf	
 If below_moon_surface=True And screen_counter=11 Then
  Select underground_down_screen_counter
   Case 1                                    ;u_screen_29
	reset_ledges()
	roof_rocks=True
	right_wall_0_on=True
	ledge_1=True
	ledge_1_x=500
	ledge_1_y=360
	g_ledge_1_x=120;620
	g_ledge_1_y=494;84
	g_ledge_2_x=340;620
	g_ledge_2_y=494;484
	g_ledge_3_x=400;620
	g_ledge_3_y=494;484
	u_screen_log=29
	enemy_3=True
	enemy_4=True
	enemy_5=True
	launch_enemies()
	animate_enemies()
   Case 2                                    ;u_screen_28
	reset_ledges()
	left_wall_0_on=True
	right_wall_0_on=True
	ledge_0=True
	ledge_1=True
	ledge_2=True
	ledge_3=True
	ledge_4=True
	ledge_0_x=160
	ledge_0_y=120
	ledge_1_x=620
	ledge_1_y=200
	ledge_3_x=320     
	ledge_3_y=210
	ledge_2_x=440
	ledge_2_y=320
	ledge_4_x=300     
	ledge_4_y=420
	u_screen_log=28
	enemy_1=True
	enemy_2=True
	enemy_3=True
	launch_enemies()
	animate_enemies()
   Case 3                                    ;u_screen_26
	reset_ledges()
	right_wall_0_on=True
	ledge_4=True
	ledge_4_x=620
	ledge_4_y=360
	p_ledge_2_x=200
	p_ledge_2_y=400
	mid_pole_ledges=True
	p_ledge_0_x=400
	p_ledge_0_y=306
	p_ledge_4_x=400
	p_ledge_4_y=353
	p_ledge_1_x=400
	p_ledge_1_y=400
	extra_tall_pole_ledges=True	
	Part_floor_left_on=True
	Part_floor_mid_on=True
	g_ledge_1_x=512
	g_ledge_1_y=495
	u_screen_log=26
	enemy_5=True
	enemy_9=True
	launch_enemies()
	animate_enemies()
   Case 4                                    ;u_screen_27
	reset_ledges()
	left_wall_0_on=True
	right_wall_0_on=True
	ledge_4=True
	ledge_1=True
	ledge_4_x=620
	ledge_4_y=200
	ledge_1_x=460
	ledge_1_y=360
	floor_on=True
	u_screen_log=27
	enemy_1=True
	enemy_5=True
	enemy_10=True
	launch_enemies()
	animate_enemies()		
	End Select			
EndIf

 If below_moon_surface=True And screen_counter=13 Then
  Select underground_down_screen_counter
   Case 0                                    ;u_screen_32 
	reset_ledges()
	left_wall_0_on=True
	ledge_3=True
	ledge_3_x=310;420
	ledge_3_y=200;190
	p_ledge_0_x=480
	p_ledge_0_y=353;352
	p_ledge_1_x=480 ;long legs
	p_ledge_1_y=400
	tall_pole_ledges=True
	floor_on=True
	u_screen_log=32
	enemy_1=True
	enemy_5=True
	enemy_9=True
	launch_enemies()
	animate_enemies()
   Case 1                                    ;u_screen_37
	reset_ledges()
	roof_rocks=True
	left_wall_0_on=True
	ledge_1=True
	ledge_1_x=260
	ledge_1_y=460
	g_ledge_0_x=620;620
	g_ledge_0_y=484
	u_screen_log=37
	enemy_1=True
	enemy_2=True
	enemy_3=True
	launch_enemies()
	animate_enemies()
   Case 2                                    ;u_screen_38
	reset_ledges()
	left_wall_0_on=True
	right_wall_0_on=True
	ledge_3=True
	ledge_3_x=425;400
	ledge_3_y=200;160
	If alchiem_count4=False
	alchiem4_x=260;400
	alchiem4_y=323;200;400	
	alchiem4=True	;Square	
	EndIf
	p_ledge_0_x=260;500
	p_ledge_0_y=353;352
	p_ledge_1_x=260;500 ;long legs
	p_ledge_1_y=400
	tall_pole_ledges=True
	floor_on=True
	u_screen_log=38
	enemy_10=True
	launch_enemies()
	animate_enemies()
 	End Select			
EndIf

 If below_moon_surface=True And screen_counter=14 Then
  Select underground_down_screen_counter
   Case 0                                    ;u_screen_33 
	reset_ledges()
	roof_rocks=True
	floor_on=True
	u_screen_log=33
	enemy_1=True
	enemy_2=True
	enemy_10=True
	launch_enemies()
	animate_enemies()
   Case 1                                    ;u_screen_36
	reset_ledges()
	roof_rocks=True
	p_ledge_2_x=400
	p_ledge_2_y=400
	mid_pole_ledges=True
	p_ledge_3_x=200
	p_ledge_3_y=400
	small_pole_ledges=True
	mid_pole_ledges=True	
	floor_on=True
	u_screen_log=36
	enemy_1=True
	enemy_9=True
	enemy_10=True
	launch_enemies()
	animate_enemies()
 	End Select			
EndIf

 If below_moon_surface=True And screen_counter=15 Then
  Select underground_down_screen_counter
   Case 0                                    ;u_screen_34 
	reset_ledges()
	roof_rocks=True
	right_wall_0_on=True
	Part_floor_left_on=True
	Part_floor_right_on=True
	u_screen_log=34
	enemy_8=True
	launch_enemies()
	animate_enemies()
   Case 1                                    ;u_screen_35
	reset_ledges()
	right_wall_0_on=True
	ledge_0=True
	ledge_1=True
	ledge_3=True
	ledge_0_x=260
	ledge_0_y=160
	ledge_1_x=460
	ledge_1_y=260
	ledge_3_x=420
	ledge_3_y=190
	g_ledge_1_x=120
	g_ledge_1_y=484
	u_screen_log=35
	enemy_1=True
	enemy_3=True
	enemy_4=True
	launch_enemies()
	animate_enemies()
   Case 2                                    ;u_screen_39
	reset_ledges()
	left_wall_0_on=True
	right_wall_0_on=True
	ledge_3=True
	ledge_3_x=320    
	ledge_3_y=190
	p_ledge_0_x=500
	p_ledge_0_y=353;352
	p_ledge_1_x=500 ;long legs
	p_ledge_1_y=400
	tall_pole_ledges=True
	floor_on=True
	u_screen_log=39
	enemy_1=True
	enemy_3=True
	enemy_9=True
	launch_enemies()
	animate_enemies()
 	End Select			
EndIf
End Function

Function reset_ledges()
	left_wall_0_on=False
	right_wall_0_on=False
		
	ledge_0=False
	ledge_1=False
	ledge_2=False
	ledge_3=False
	ledge_4=False
	ledge_5=False
	ledge_6=False
	
	ledge_0_x=-150
	ledge_0_y=-150
	ledge_1_x=-150
	ledge_1_y=-150
	ledge_2_x=-150
	ledge_2_y=-150
	ledge_3_x=-150
	ledge_3_y=-150
	ledge_4_x=-150
	ledge_4_y=-150
	ledge_5_x=-150
	ledge_5_y=-150
	ledge_6_x=-150
	ledge_6_y=-150
	g_ledge_0_x=-150
	g_ledge_0_y=-150
	g_ledge_1_x=-150
	g_ledge_1_y=-150
	g_ledge_2_x=-150
	g_ledge_2_y=-150
	g_ledge_3_x=-150
	g_ledge_3_y=-150
;	poleledge_x=0
;	poleledge_y=0

	p_ledge_0_x=-150
	p_ledge_0_y=-150
	p_ledge_1_x=-150
	p_ledge_1_y=-150
	p_ledge_2_x=-150
	p_ledge_2_y=-150
	p_ledge_3_x=-150
	p_ledge_3_y=-150
	p_ledge_4_x=-150
	p_ledge_4_y=-150
	
	green_ledge_0=False
	green_ledge_1=False
	green_ledge_2=False
	green_ledge_3=False
	
	pole_ledges=False
	
	small_pole_ledges=False
	mid_pole_ledges=False
	tall_pole_ledges=False
	
	roof_rocks=False
	floor_on=False
;	Part_floor_on=False
	Part_floor_left_on=False
	Part_floor_mid_on=False
	Part_floor_right_on=False
	ledge_0=False
	ledge_1=False
	ledge_2=False
	ledge_3=False
	ledge_4=False
	ledge_5=False
	ledge_6=False
	
	alchiem1=False	;Square
	alchiem2=False	;Triangle
	alchiem3=False	;Circle
	alchiem4=False	;Diamond	
	
	enemy_1=False
	enemy_2=False
	enemy_3=False
	enemy_4=False
	enemy_5=False
	enemy_6=False
	enemy_7=False
	enemy_8=False
	enemy_9=False
	enemy_10=False
	enemy_11=False	
End Function

Function up_rocks_0()
	 upper_rock_counter_0=0
	 upper_rock_counter_1=1
	 upper_rock_counter_2=2
	 upper_rock_counter_3=3
	 upper_rock_counter_4=2
	 upper_rock_counter_5=1
	 upper_rock_counter_6=3
	 upper_rock_counter_7=0
End Function

Function up_rocks_1()
	 upper_rock_counter_0=2
	 upper_rock_counter_1=1
	 upper_rock_counter_2=3
	 upper_rock_counter_3=0
	 upper_rock_counter_4=1
	 upper_rock_counter_5=3
	 upper_rock_counter_6=1
	 upper_rock_counter_7=0
End Function

Function up_rocks_2()
	 upper_rock_counter_0=1
	 upper_rock_counter_1=2
	 upper_rock_counter_2=3
	 upper_rock_counter_3=0
	 upper_rock_counter_4=1
	 upper_rock_counter_5=3
	 upper_rock_counter_6=3
	 upper_rock_counter_7=0
End Function

Function up_rocks_3()
	 upper_rock_counter_0=3
	 upper_rock_counter_1=1
	 upper_rock_counter_2=2
	 upper_rock_counter_3=0
	 upper_rock_counter_4=3
	 upper_rock_counter_5=2
	 upper_rock_counter_6=0
	 upper_rock_counter_7=1
End Function	

Function up_rocks_4()
	 upper_rock_counter_0=1
	 upper_rock_counter_1=2
	 upper_rock_counter_2=3
	 upper_rock_counter_3=0
	 upper_rock_counter_4=1
	 upper_rock_counter_5=2
	 upper_rock_counter_6=2
	 upper_rock_counter_7=0
End Function

Function low_rocks_0()
	lower_rock_counter_0=5
	lower_rock_counter_1=6
	lower_rock_counter_2=7
	lower_rock_counter_3=8
	lower_rock_counter_4=5
	lower_rock_counter_5=6
	lower_rock_counter_6=7
	lower_rock_counter_7=6
End Function

Function low_rocks_1()
	lower_rock_counter_0=5
	lower_rock_counter_1=6
	lower_rock_counter_2=7
	lower_rock_counter_3=8
	lower_rock_counter_4=7
	lower_rock_counter_5=8
	lower_rock_counter_6=5
	lower_rock_counter_7=6
End Function

Function low_rocks_2()
	lower_rock_counter_0=5
	lower_rock_counter_1=6
	lower_rock_counter_2=5
	lower_rock_counter_3=6
	lower_rock_counter_4=7
	lower_rock_counter_5=8
	lower_rock_counter_6=7
	lower_rock_counter_7=8
End Function

Function low_rocks_3()
	lower_rock_counter_0=7
	lower_rock_counter_1=8
	lower_rock_counter_2=5
	lower_rock_counter_3=6
	lower_rock_counter_4=7
	lower_rock_counter_5=8
	lower_rock_counter_6=7
	lower_rock_counter_7=8
End Function

Function low_rocks_4()
	lower_rock_counter_0=5
	lower_rock_counter_1=6
	lower_rock_counter_2=7
	lower_rock_counter_3=8
	lower_rock_counter_4=7
	lower_rock_counter_5=8
	lower_rock_counter_6=7
	lower_rock_counter_7=6
End Function

;//////////////////////////////////////////////////////////
;/ Function to check for collision of the man & the floor /
;//////////////////////////////////////////////////////////
Function man_and_floor_collision()
If floor_on=True And below_moon_surface=True Then ;And floor_on=True Then
; Color 255,255,255
; Rect 113,446+64,700,20,solid=1
  If ImageRectCollide(sprites,horpos,verpos,frame1,113,446+64,700,10)=True Then
 ;   If horpos=>000 And horpos=<800 And verpos=>446 verpos=446 falling=False 
	If horpos=>000-64 And horpos=<800+64 falling=False verpos=448;446 
  Else 
	;falling=True
	If falling=False And horpos=<000 falling=True
	If falling=False And horpos=>800 falling=True
	EndIf
	EndIf
End Function

;/////////////////////////////////////////////////////////////////////////
;/ Function to check for collision of the man & the floor with a hole in /
;/////////////////////////////////////////////////////////////////////////
;Function man_and_part_floor_left_collision()
Function man_and_part_floor_collision()
If Part_floor_left_on=True And below_moon_surface=True Then ;And floor_on=True Then
; Color 255,255,255
; Rect 113,446+64,700,20,solid=1
  If ImageRectCollide(sprites,horpos,verpos,frame1,113,446+64,700,10)=True Then
 	If horpos=>000-64 And horpos=<300+44 falling=False verpos=446 ;falling=False
								;300+64
  Else 
EndIf
EndIf
;End Function

;Function man_and_part_floor_mid_collision()
If Part_floor_mid_on=True And below_moon_surface=True Then ;And floor_on=True Then
; Color 255,255,255
; Rect 113,446+64,700,20,solid=1
  If ImageRectCollide(sprites,horpos,verpos,frame1,313,446+64,700,10)=True Then
	If horpos=>300-64 And horpos=<500+64 falling=False verpos=446 ;falling=False
  Else 
EndIf
EndIf
;End Function

;Function man_and_part_floor_right_collision()
If Part_floor_right_on=True And below_moon_surface=True Then ;And floor_on=True Then
; Color 255,255,255
; Rect 113,446+64,700,20,solid=1
  If ImageRectCollide(sprites,horpos,verpos,frame1,113,446+64,700,10)=True Then
	If horpos=>500-64 And horpos=<800+64 falling=False verpos=446 ;falling=False
  Else 
EndIf
EndIf
End Function

;/////////////////////////////////////////////////////
;/ Function to check for collision of the man & hole /
;/////////////////////////////////////////////////////
Function man_and_hole_collision()

If hole1=True And below_moon_surface=False Then
; Color 255,255,255
; Rect 320,460,40,20,solid=1
  If ImageRectCollide(sprites,horpos,verpos,frame1,320,460,40,10)=True Then
	PlaySound died
	 hole_collision=True
	 below_moon_surface=True
	 underground_switch=True
	 falling=True
	 hole_collision=False	
	Else
	 hole_collision=False
	EndIf
	EndIf
	
If hole2=True And below_moon_surface=False Then
;Rect 520,460,40,20,solid=1
If ImageRectCollide(sprites,horpos,verpos,frame1,520,460,40,10)=True Then
	PlaySound died
	 hole_collision=True
	 below_moon_surface=True
	 underground_switch=True
	 falling=True
	 hole_collision=False
	Else
	 hole_collision=False
	EndIf
	EndIf	
End Function

;////////////////////////////////
;/ Collision check with ledge 0 /			
;////////////////////////////////
Function man_and_ledge0_collision_check()
If below_moon_surface=True
; Color 155,155,155
 ;Color 222,333,444
 ; Rect ledge_0_x-50,ledge_0_y+20,70,20,solid=1
;  Rect ledge_0_x-50,ledge_0_y+20,270,20,solid=1
   If ImageRectCollide(sprites,horpos,verpos,frame1,ledge_0_x,ledge_0_y+20,52,20)=True Then ;70

;If falling_counter=<2 Then falling_counter=0


	If horpos=>(ledge_0_x-40) And horpos=<(ledge_0_x+30) falling=False verpos=ledge_0_y-40
  ;  If horpos=>(ledge_0_x-64) And horpos=<(ledge_0_x+75) falling=False verpos=ledge_0_y-40 
	Else
;	    If falling=False And horpos=<ledge_0_x And verpos=<ledge_0_y falling=True
;  If falling=False And horpos=>ledge_0_x+50 And verpos=<ledge_0_y falling=True
    If falling=False And horpos=<ledge_0_x falling=True
  If falling=False And horpos=>ledge_0_x+50 falling=True ;75
 EndIf
EndIf
End Function

;////////////////////////////////
;/ Collision check with ledge 1 /			
;////////////////////////////////
Function man_and_ledge1_collision_check()
If below_moon_surface=True
; Color 155,155,155
;Color 222,333,444
;  Rect ledge_1_x,ledge_1_y+20,50,20,solid=1 ;70

   If ImageRectCollide(sprites,horpos,verpos,frame1,ledge_1_x,ledge_1_y+20,60,20)=True Then;70

;If falling_counter=<2 Then falling_counter=0

    If horpos=>(ledge_1_x-40) And horpos=<(ledge_1_x+30) falling=False verpos=ledge_1_y-40
	;If horpos=>(ledge_1_x-64) And horpos=<(ledge_1_x+100) falling=False verpos=ledge_1_y-40
     Else
    If falling=False And horpos=<ledge_1_x And verpos=ledge_1_y falling=True
  If falling=False And horpos=>ledge_1_x+60 And verpos=ledge_1_y falling=True;75
 EndIf
EndIf
End Function

;////////////////////////////////
;/ Collision check with ledge 2 /			
;////////////////////////////////
Function man_and_ledge2_collision_check()
If below_moon_surface=True
; Color 255,255,255
;  Rect ledge_2_x,ledge_2_y+20,70,20,solid=1
   If ImageRectCollide(sprites,horpos,verpos,frame1,ledge_2_x,ledge_2_y+20,70,20)=True Then

;If falling_counter=<2 Then falling_counter=0

	If horpos=>(ledge_2_x-40) And horpos=<(ledge_2_x+30) falling=False verpos=ledge_2_y-40
	;If horpos=>(ledge_2_x-64) And horpos=<(ledge_2_x+100) falling=False verpos=ledge_2_y-40
    Else
   If falling=False And horpos=<ledge_2_x And verpos=ledge_2_y falling=True
  If falling=False And horpos=>ledge_2_x+75 And verpos=ledge_2_y falling=True
 EndIf
EndIf
End Function

;////////////////////////////////
;/ Collision check with ledge 3 /			
;////////////////////////////////
Function man_and_ledge3_collision_check()
If below_moon_surface=True
; Color 111,111,111;255,255
;  Rect ledge_3_x,ledge_3_y+20,64,20,solid=1							      ;70
   If ImageRectCollide(sprites,horpos,verpos,frame1,ledge_3_x,ledge_3_y+20,64,20)=True Then

;If falling_counter<2 Then falling_counter=0

													;44
	If horpos=>(ledge_3_x-40) And horpos=<(ledge_3_x+40) Then 
	falling=False verpos=ledge_3_y-40
	
;	If falling_counter<2 Then falling_counter=0
	
	EndIf
	
	
;	If horpos=>(ledge_3_x-64) And horpos=<(ledge_3_x+100) falling=False verpos=ledge_3_y-40
    Else
   If falling=False And horpos=<ledge_3_x And verpos=ledge_3_y falling=True
										;75
  If falling=False And horpos=>ledge_3_x+70 And verpos=ledge_3_y falling=True
 EndIf
EndIf
End Function

;////////////////////////////////
;/ Collision check with ledge 4 /			
;////////////////////////////////
Function man_and_ledge4_collision_check()
If below_moon_surface=True
; Color 111,222,333;255,255,255
;  Rect ledge_4_x,ledge_4_y+20,70,20,solid=1
   If ImageRectCollide(sprites,horpos,verpos,frame1,ledge_4_x,ledge_4_y+20,70,20)=True Then
	If horpos=>(ledge_4_x-40) And horpos=<(ledge_4_x+44) falling=False verpos=ledge_4_y-40
;	If horpos=>(ledge_4_x-64) And horpos=<(ledge_4_x+100) falling=False verpos=ledge_4_y-40 
   Else
   If falling=False And horpos=<ledge_4_x And verpos=ledge_4_y falling=True
  If falling=False And horpos=>ledge_4_x+75 And verpos=ledge_4_y falling=True
 EndIf
EndIf
End Function

;////////////////////////////////
;/ Collision check with ledge 5 /			
;////////////////////////////////
Function man_and_ledge5_collision_check()
If below_moon_surface=True
; Color 111,255,111
;  Rect ledge_5_x,ledge_5_y+20,70,20,solid=1
   If ImageRectCollide(sprites,horpos,verpos,frame1,ledge_5_x,ledge_5_y+20,70,20)=True Then
	If horpos=>(ledge_5_x-40) And horpos=<(ledge_5_x+44) falling=False verpos=ledge_5_y-40
;	If horpos=>(ledge_5_x-64) And horpos=<(ledge_5_x+100) falling=False verpos=ledge_5_y-40
    Else
   If falling=False And horpos=<ledge_5_x And verpos=ledge_5_y falling=True
  If falling=False And horpos=>ledge_5_x+75 And verpos=ledge_5_y falling=True
 EndIf
EndIf
End Function

;////////////////////////////////
;/ Collision check with ledge 6 /			
;////////////////////////////////
Function man_and_ledge6_collision_check()
If below_moon_surface=True
; Color 111,255,111
;  Rect ledge_6_x,ledge_6_y+20,70,20,solid=1
   If ImageRectCollide(sprites,horpos,verpos,frame1,ledge_6_x,ledge_6_y+20,70,20)=True Then
	If horpos=>(ledge_6_x-40) And horpos=<(ledge_6_x+44) falling=False verpos=ledge_6_y-40
;	If horpos=>(ledge_6_x-64) And horpos=<(ledge_6_x+100) falling=False verpos=ledge_6_y-40
    Else
   If falling=False And horpos=<ledge_6_x And verpos=ledge_6_y falling=True
  If falling=False And horpos=>ledge_6_x+75 And verpos=ledge_6_y falling=True
 EndIf
EndIf
End Function

;////////////////////////////////////
;/ Collision check with green ledge /			
;////////////////////////////////////
Function man_and_g_ledge_0_collision_check()
If below_moon_surface=True Then

;If green_ledge_0=True

; Color 111,255,111
;  Rect g_ledge_0_x,g_ledge_0_y+20,70,20,solid=1
   If ImageRectCollide(sprites,horpos,verpos,frame1,g_ledge_0_x,g_ledge_0_y+20,70,20)=True Then
	If horpos=>(g_ledge_0_x-40) And horpos=<(g_ledge_0_x+44) falling=False verpos=g_ledge_0_y-46;40
;	If horpos=>(ledge_6_x-64) And horpos=<(ledge_6_x+100) falling=False verpos=ledge_6_y-40
    Else
   If falling=False And horpos=<g_ledge_0_x And verpos=g_ledge_0_y falling=True
  If falling=False And horpos=>g_ledge_0_x+75 And verpos=g_ledge_0_y falling=True
 EndIf
;EndIf

;If green_ledge_2=True

   If ImageRectCollide(sprites,horpos,verpos,frame1,g_ledge_2_x,g_ledge_2_y+20,70,20)=True Then
	If horpos=>(g_ledge_2_x-40) And horpos=<(g_ledge_2_x+44) falling=False verpos=g_ledge_2_y-46;40
;	If horpos=>(ledge_6_x-64) And horpos=<(ledge_6_x+100) falling=False verpos=ledge_6_y-40
    Else
   If falling=False And horpos=<g_ledge_2_x And verpos=g_ledge_2_y falling=True
  If falling=False And horpos=>g_ledge_2_x+75 And verpos=g_ledge_2_y falling=True
 EndIf
EndIf
;EndIf
End Function

;////////////////////////////////////
;/ Collision check with green ledge /			
;////////////////////////////////////
Function man_and_g_ledge_1_collision_check()
If below_moon_surface=True Then
; Color 111,255,111
;  Rect g_ledge_1_x,g_ledge_1_y+20,70,20,solid=1                           ;+20
   If ImageRectCollide(sprites,horpos,verpos,frame1,g_ledge_1_x,g_ledge_1_y,70,20)=True Then
	If horpos=>(g_ledge_1_x-40) And horpos=<(g_ledge_1_x+24) falling=False verpos=g_ledge_1_y-46;40
													  ;+44
    Else
   If falling=False And horpos=<g_ledge_1_x And verpos=g_ledge_1_y falling=True
  If falling=False And horpos=>g_ledge_1_x+55 And verpos=g_ledge_1_y falling=True ;75
 EndIf
;EndIf
;If green_ledge_3=True
   If ImageRectCollide(sprites,horpos,verpos,frame1,g_ledge_3_x,g_ledge_3_y+20,70,20)=True Then
	If horpos=>(g_ledge_3_x-40) And horpos=<(g_ledge_3_x+44) falling=False verpos=g_ledge_3_y-46;40
;	If horpos=>(ledge_6_x-64) And horpos=<(ledge_6_x+100) falling=False verpos=ledge_6_y-40
    Else
   If falling=False And horpos=<g_ledge_3_x And verpos=g_ledge_3_y falling=True
  If falling=False And horpos=>g_ledge_3_x+75 And verpos=g_ledge_3_y falling=True
 EndIf
EndIf
;EndIf
End Function

;////////////////////////////////////////
;/ Collision check with ledges on Poles /			
;////////////////////////////////////////
Function man_and_poleledge_collision_check()
If below_moon_surface=True
;If below_moon_surface And tall_pole_ledges=True Or extra_tall_pole_ledges=True
If tall_pole_ledges=True Or extra_tall_pole_ledges=True
; Color 222,333,444
;  Rect p_ledge_0_x-50,p_ledge_0_y+20,70,20,solid=1
	If ImageRectCollide(sprites,horpos,verpos,frame1,p_ledge_0_x,p_ledge_0_y+20,60,20)=True Then
	If horpos=>(p_ledge_0_x-40) And horpos=<(p_ledge_0_x+38) falling=False verpos=p_ledge_0_y-30
	Else
 EndIf
EndIf

If mid_pole_ledges=True
; Color 255,255,255
;  Rect p_ledge_2_x,p_ledge_2_y+40,60,20,solid=1							   ;20
   If ImageRectCollide(sprites,horpos,verpos,frame1,p_ledge_2_x,p_ledge_2_y+36,60,20)=True Then ;70
	If horpos=>(p_ledge_2_x-40) And horpos=<(p_ledge_2_x+38) falling=False verpos=p_ledge_2_y-30
	Else
 EndIf
EndIf

If small_pole_ledges=True
; Color 255,255,255
;  Rect p_ledge_3_x,p_ledge_3_y+40,60,20,solid=1						  ;+20   
   If ImageRectCollide(sprites,horpos,verpos,frame1,p_ledge_3_x,p_ledge_3_y+36,60,20)=True Then ;70
	If horpos=>(p_ledge_3_x-40) And horpos=<(p_ledge_3_x+38) falling=False verpos=p_ledge_3_y+20;-30
	Else
 EndIf
EndIf
EndIf
End Function

;/////////////////////////////////////////////
;/ Collision check with Spaceman and enemies /			
;/////////////////////////////////////////////
Function man_and_enemy_collision_checks()
If below_moon_surface=True
; Color 255,255,255
;  Rect p_ledge_2_x,p_ledge_2_y+20,70,20,solid=1
   If ImageRectCollide(sprites,horpos,verpos,frame1,p_ledge_2_x,p_ledge_2_y+20,52,20)=True Then ;70
;	If horpos=>(p_ledge_2_x-40) And horpos=<(p_ledge_2_x+40) falling=False verpos=p_ledge_2_y-30
;	Else
 EndIf
EndIf
End Function


;//////////////////////////////////////////////
;/ Collision check with Spaceman and Alchiems /			
;//////////////////////////////////////////////
Function man_and_alchiem_collision_check()
If below_moon_surface=True
 If alchiem_count1=False And ImageRectCollide(sprites,horpos,verpos,frame1,alchiem1_x,alchiem1_y+20,52,20)=True Then
 alchiem_count1=True alchiem_counter=alchiem_counter+1  ; Square Alchiem
 EndIf
 If alchiem_count2=False And ImageRectCollide(sprites,horpos,verpos,frame1,alchiem2_x,alchiem2_y+20,52,20)=True Then
 alchiem_counter=alchiem_counter+1 alchiem_count2=True	; Triangular Alchiem
 EndIf
  If alchiem_count3=False And ImageRectCollide(sprites,horpos,verpos,frame1,alchiem3_x,alchiem3_y+20,52,20)=True Then
 alchiem_counter=alchiem_counter+1 alchiem_count3=True	; Round Alchiem
 EndIf
  If alchiem_count4=False And ImageRectCollide(sprites,horpos,verpos,frame1,alchiem4_x,alchiem4_y+20,52,20)=True Then
 alchiem_counter=alchiem_counter+1 alchiem_count4=True	; Diamond Alchiem
 EndIf
EndIf
End Function

;///////////////////////////////////
;/ Function to initialise Spaceman /
;///////////////////////////////////
Function launch_space_man()
 s.spaceman = New spaceman 
 s\spacemanverpos = 400		;vertical position
 s\spacemanhorpos = 150		;horizontal position
; s\spaceman_spritepage = 0	;spaceman sprite image
 s\spaceman_r_dying_spritepage = 228;201
 s\spaceman_l_dying_spritepage = 234
 s\jumpright_spritepage = 19
 s\jumpleft_spritepage = 55
 s\jumpupright_spritepage = 58
 s\jumpupleft_spritepage = 73
End Function

;/////////////////////////////////
;/ Function to Draw the Spaceman /
;/////////////////////////////////
Function animate_space_man()

	If man_right=True And switch_right=True And jump=False And falling=False And die_anim=False Then
	  If MilliSecs()>spaceman_timer + 80 Then ;100
	   spaceman_timer=MilliSecs()
 	   spaceman_spritepage=spaceman_spritepage+1; 
	  If spaceman_spritepage>7 And switch_right=True Then spaceman_spritepage=0
;	facing_wrong_way_flag=True
	  EndIf
	 DrawImage (sprites),horpos,verpos,spaceman_spritepage
Else
	If man_left=True And switch_left=True And jump=False And falling=False And die_anim=False Then
	  If MilliSecs()>spaceman_timer + 80 Then ;100 
	   spaceman_timer=MilliSecs()
	   spaceman_spritepage=spaceman_spritepage-1;
	  If spaceman_spritepage<11 And switch_left=True Then spaceman_spritepage=18
;	facing_wrong_way_flag=False
	  EndIf
	 DrawImage (sprites),horpos,verpos,spaceman_spritepage

Else ;summersault jump right

;	If jump=True And man_right=True And die_anim=False Then
;;	  For s.spaceman = Each spaceman
;		If MilliSecs()>jumping_timer + 50 Then
;		jumping_timer=MilliSecs()
;		horpos=horpos+10
;;		s\spacemanhorpos=horpos
;;		s\spacemanverpos=verpos
;		jumpright_spritepage=jumpright_spritepage+1
;		If jumpright_spritepage>19 And jumpright_spritepage<28 Then verpos=verpos-25
;		If jumpright_spritepage=>28 And jumpright_spritepage<36 Then verpos=verpos+25
;	   If jumpright_spritepage>36 Then jumpright_spritepage=19 jump=False falling=False
;	  EndIf
;	 DrawImage (sprites),horpos,verpos,jumpright_spritepage
;	Next
	If jump=True And man_right=True And die_anim=False Then
	  For s.spaceman = Each spaceman
		If MilliSecs()>jumping_timer + 50 Then
		jumping_timer=MilliSecs()
		horpos=horpos+10
		s\spacemanhorpos=horpos
		s\spacemanverpos=verpos
		s\jumpright_spritepage=s\jumpright_spritepage+1
		If s\jumpright_spritepage>19 And s\jumpright_spritepage<28 Then verpos=verpos-25
		If s\jumpright_spritepage=>28 And s\jumpright_spritepage<36 Then verpos=verpos+25
	   If s\jumpright_spritepage>36 Then s\jumpright_spritepage=19 jump=False falling=False
	  EndIf
	 DrawImage (sprites),s\spacemanhorpos,s\spacemanverpos,s\jumpright_spritepage
	Next
	
	
Else ;summersault jump left ;switch_left

	If jump=True And man_left=True And die_anim=False Then
	  For s.spaceman = Each spaceman
		If MilliSecs()>jumping_timer + 50 Then
		jumping_timer=MilliSecs()
		horpos=horpos-10
		s\spacemanhorpos=horpos
		s\spacemanverpos=verpos
	;	jumping_timer=MilliSecs()
		s\jumpleft_spritepage=s\jumpleft_spritepage-1
		If s\jumpleft_spritepage<55 And s\jumpleft_spritepage>47 Then verpos=verpos-25
		If s\jumpleft_spritepage=<46 And s\jumpleft_spritepage>39 Then verpos=verpos+25
	   If s\jumpleft_spritepage<39 Then s\jumpleft_spritepage=55 jump=False falling=False;summersault_jump_flag=False
	  EndIf
	 DrawImage (sprites),s\spacemanhorpos,s\spacemanverpos,s\jumpleft_spritepage
	Next	

Else 

	;Jump upwards when facing left
	If jump_up=True And man_left=True And die_anim=False Then
		If MilliSecs()>jumpingup_timer + 50 Then
		verpos=verpos-10
		jumpingup_timer=MilliSecs()
		jumpupleft_spritepage=jumpupleft_spritepage-1
	   If jumpupleft_spritepage<66 Then jumpupleft_spritepage=73 jump_up=False;jump=False
	  EndIf
	 DrawImage (sprites),horpos,verpos,jumpupleft_spritepage

Else

	;Jump upwards when facing right
	If jump_up=True And man_Right=True And die_anim=False Then
		If MilliSecs()>jumpingup_timer + 50 Then
		verpos=verpos-10
		jumpingup_timer=MilliSecs()
		jumpupleft_spritepage=jumpupleft_spritepage+1
	   If jumpupleft_spritepage>64 Then jumpupleft_spritepage=57 jump_up=False;jump=False
	  EndIf
	 DrawImage (sprites),horpos,verpos,jumpupleft_spritepage
;	Next

;	;Jump upwards when facing right
;	If jump_up=True And man_Right=True And die_anim=False Then
;	  For s.spaceman = Each spaceman
;		If MilliSecs()>jumpingup_timer + 50 Then
;		verpos=verpos-10
;		s\spacemanverpos=verpos
;		jumpingup_timer=MilliSecs()
;		s\jumpupleft_spritepage=s\jumpupleft_spritepage+1
;	   If s\jumpupleft_spritepage>64 Then s\jumpupleft_spritepage=57 jump_up=False;jump=False
;	  EndIf
;	 DrawImage (sprites),s\spacemanhorpos,s\spacemanverpos,s\jumpupleft_spritepage
;	Next
Else 

;;If jump=False And below_moon_surface=True And ledge_collision=False Then
	If jump=False And below_moon_surface=True And falling=True And die_anim=False Then
;	 For s.spaceman = Each spaceman
	  verpos=verpos+2
;	  s\spacemanverpos=verpos
;	  s\spacemanhorpos=horpos
;	 DrawImage (sprites),s\spacemanhorpos,s\spacemanverpos,s\spaceman_spritepage
	 DrawImage (sprites),horpos,verpos,spaceman_spritepage
;	Next

Else

	If jump=False And die_anim=False Then
;	 For s.spaceman = Each spaceman
;	  s\spacemanverpos=verpos
;	  s\spacemanhorpos=horpos
;	 DrawImage (sprites),s\spacemanhorpos,s\spacemanverpos,s\spaceman_spritepage
	 DrawImage (sprites),horpos,verpos,spaceman_spritepage
;	Next

Else

	If die_anim=True And man_right=True Then
	 For s.spaceman = Each spaceman
	  If MilliSecs()>dying_timer + 500 Then
	  dying_timer=MilliSecs()
	  s\spacemanverpos=verpos
	  s\spacemanhorpos=horpos
	  s\spaceman_r_dying_spritepage=s\spaceman_r_dying_spritepage+1
									;206
	  If s\spaceman_r_dying_spritepage=>233 Then die_anim=False s\spaceman_r_dying_spritepage=228;201 
	  EndIf
	 DrawImage (sprites),s\spacemanhorpos,s\spacemanverpos,s\spaceman_r_dying_spritepage
	Next

Else

	If die_anim=True And man_left=True Then
	 For s.spaceman = Each spaceman
	  If MilliSecs()>dying_timer + 500 Then
	  dying_timer=MilliSecs()
	  s\spacemanverpos=verpos
	  s\spacemanhorpos=horpos
	  s\spaceman_l_dying_spritepage=s\spaceman_l_dying_spritepage+1
									;206
	  If s\spaceman_l_dying_spritepage=>239 Then die_anim=False s\spaceman_l_dying_spritepage=234;201 
	  EndIf
	 DrawImage (sprites),s\spacemanhorpos,s\spacemanverpos,s\spaceman_l_dying_spritepage
	Next


EndIf

EndIf

EndIf
EndIf
EndIf
EndIf
EndIf
EndIf
EndIf
EndIf
End Function

;////////////////////////////////////
;/ Function to initialise the Earth /
;////////////////////////////////////
;Function launch_earth()
; e.earth = New earth
; e\earthverpos = 600
; e\earthhorpos = 60
; e\earth_spritepage = 247;154
;End Function

;//////////////////////////////
;/ Function to Draw the Earth /
;//////////////////////////////
Function animate_earth_and_rocket()
;   For e.earth = Each earth
	If MilliSecs()>earth_timer + 200 Then 
	 earth_timer=MilliSecs()
	 earth_spritepage=earth_spritepage+1
	EndIf
   DrawImage (sprites),earthverpos,earthhorpos,earth_spritepage
   earth_debug=earth_spritepage
  If earth_spritepage>=253 Then earth_spritepage=247; >159 154
; Next
;   For e.earth = Each earth
;	If MilliSecs()>earth_timer + 200 Then 
;	 earth_timer=MilliSecs()
;	 e\earth_spritepage=e\earth_spritepage+1
;	EndIf
;   DrawImage (sprites),e\earthverpos,e\earthhorpos,e\earth_spritepage
;   earth_debug=e\earth_spritepage
;  If e\earth_spritepage>=253 Then e\earth_spritepage=247; >159 154
; Next
End Function

;////////////////////////////////////
;/ Function to initialise the Earth /
;////////////////////////////////////
Function launch_enemies()
If launched=False
 e.enemy = New enemy

If enemy_1=True ; Spring Bear
 e\enemy_1_verpos = 300;600
 e\enemy_1_horpos = 200;600;220
 e\enemy_1_spritepage = 176; start with explosion then 114;107
EndIf
If enemy_2=True ; Spring Bear
 e\enemy_2_verpos = 500
 e\enemy_2_horpos = 160
 e\enemy_2_spritepage = 176; start with explosion then 114
EndIf
If enemy_3=True ; Little Big Nose
 e\enemy_3_verpos = 400;580
 e\enemy_3_horpos = 160
 e\enemy_3_spritepage = 107;114
EndIf
If enemy_4=True ; Little Big Nose
 e\enemy_4_verpos = 400
 e\enemy_4_horpos = 180
 e\enemy_4_spritepage = 107;114
EndIf 
If enemy_5=True ; Space Dust
 e\enemy_5_verpos = 300
 e\enemy_5_horpos = 180
 e\enemy_5_spritepage = 173;114
EndIf
If enemy_6=True ; Space Dust
 e\enemy_6_verpos = 300
 e\enemy_6_horpos = 180
 e\enemy_6_spritepage = 173;114
EndIf
If enemy_7=True ; Fish
 e\enemy_7_verpos = 448
 e\enemy_7_horpos = 180
 e\enemy_7_spritepage = 118;114
EndIf
If enemy_8=True ; Blue Bear
 e\enemy_8_verpos = 448
 e\enemy_8_horpos = ene_8_horpos;180
 e\enemy_8_spritepage = 76;114
EndIf
If enemy_9=True ; Small Grey(green) Walker
 e\enemy_9_verpos = 450;500
 e\enemy_9_horpos = 180
 e\enemy_9_spritepage = 99;114
EndIf
If enemy_10=True ;Fire ? ; Small Grey(green) Walker
 e\enemy_10_verpos = 458;500
 e\enemy_10_horpos = 180
 e\enemy_10_spritepage = 179;189
EndIf
 launched=True
EndIf
End Function

;///////////////////////////////
;/ Function to move the Rocket /
;///////////////////////////////
Function animate_rocket()
 If rocket_x=>0 And rocket_x=<800 Then rocket_x=rocket_x+1
 If rocket_x=>801 Then rocket_x=0 rocket_screen=rocket_screen+1
 If rocket_screen>15 Then rocket_screen=0
End Function


;////////////////////////////
;/ Function to Draw Enemies /
;////////////////////////////
Function animate_enemies()
   For e.enemy = Each enemy			;140
	If MilliSecs()>enemy_timer + 240 Then 
	enemy_timer=MilliSecs()
	
	e\enemy_1_spritepage=e\enemy_1_spritepage+1
	If e\enemy_1_spritepage>178 Then e\enemy_1_spritepage=114
	If e\enemy_1_spritepage>=117 Then e\enemy_1_spritepage=114
	
	e\enemy_2_spritepage=e\enemy_2_spritepage+1
	If e\enemy_2_spritepage>=117 Then e\enemy_2_spritepage=114
	
	e\enemy_3_spritepage=e\enemy_3_spritepage+1
	If e\enemy_3_spritepage>=112 Then e\enemy_3_spritepage=107

	e\enemy_4_spritepage=e\enemy_4_spritepage+1
	If e\enemy_4_spritepage>=112 Then e\enemy_4_spritepage=107
	
	If ene_7_switchright=True	
	e\enemy_7_spritepage=e\enemy_7_spritepage+1
	If e\enemy_7_spritepage>=123 Then e\enemy_7_spritepage=118 ;98
	EndIf

	If ene_7_switchleft=True
	If flag_2=True Then e\enemy_7_spritepage=ene_7_spritepage flag_2=False
	e\enemy_7_spritepage=e\enemy_7_spritepage-1
	If e\enemy_7_spritepage<=124 Then e\enemy_7_spritepage=129
	EndIf
	
	If ene_8_switchright=True	
	e\enemy_8_spritepage=e\enemy_8_spritepage+1
	If e\enemy_8_spritepage>=85 Then e\enemy_8_spritepage=76 ;98
	EndIf
	
	If ene_8_switchleft=True
	If flag_1=True Then e\enemy_8_spritepage=ene_8_spritepage flag_1=False
	e\enemy_8_spritepage=e\enemy_8_spritepage-1
	If e\enemy_8_spritepage<=89 Then e\enemy_8_spritepage=98
	EndIf

	If ene_9_switchright=True	
	e\enemy_9_spritepage=e\enemy_9_spritepage+1
	If e\enemy_9_spritepage>=102 Then e\enemy_9_spritepage=99 ;98
	EndIf
	
	If ene_9_switchleft=True
	e\enemy_9_spritepage=e\enemy_9_spritepage+1
	If e\enemy_9_spritepage>=106 Then e\enemy_9_spritepage=102
	EndIf
	
	e\enemy_10_spritepage=e\enemy_10_spritepage+1
	If e\enemy_10_spritepage>=183 Then e\enemy_10_spritepage=179
	
	EndIf
	
	 e\enemy_1_verpos=ene_1_verpos
	 e\enemy_1_horpos=ene_1_horpos
	 e\enemy_2_verpos=ene_2_verpos
	 e\enemy_2_horpos=ene_2_horpos
	 e\enemy_3_verpos=ene_3_verpos
	 e\enemy_3_horpos=ene_3_horpos
	 e\enemy_7_verpos=ene_7_verpos
	 e\enemy_7_horpos=ene_7_horpos
	 e\enemy_8_horpos=ene_8_horpos
	
	
If enemy_1=True ; Spring Bear
	DrawImage (sprites),e\enemy_1_horpos,e\enemy_1_verpos,e\enemy_1_spritepage
EndIf
If enemy_2=True ; Spring Bear	
    DrawImage (sprites),e\enemy_2_horpos,e\enemy_2_verpos,e\enemy_2_spritepage
EndIf
If enemy_3=True ; Little Big Nose
	DrawImage (sprites),e\enemy_3_horpos,e\enemy_3_verpos,e\enemy_3_spritepage
EndIf
If enemy_4=True ; Little Big Nose
	DrawImage (sprites),e\enemy_4_horpos,e\enemy_4_verpos,e\enemy_4_spritepage
EndIf
If enemy_5=True ; Space Dust
	DrawImage (sprites),e\enemy_5_horpos,e\enemy_5_verpos,e\enemy_5_spritepage
EndIf
If enemy_6=True ; Space Dust
	DrawImage (sprites),e\enemy_6_horpos,e\enemy_6_verpos,e\enemy_6_spritepage
EndIf
If enemy_7=True ; Fish	
    DrawImage (sprites),e\enemy_7_horpos,e\enemy_7_verpos,e\enemy_7_spritepage
EndIf
If enemy_8=True ; Blue Bear
	DrawImage (sprites),e\enemy_8_horpos,e\enemy_8_verpos,e\enemy_8_spritepage
EndIf
If enemy_9=True ; Small Grey Walker
	DrawImage (sprites),e\enemy_9_horpos,e\enemy_9_verpos,e\enemy_9_spritepage
EndIf
If enemy_10=True ; Fire
	DrawImage (sprites),e\enemy_10_horpos,e\enemy_10_verpos,e\enemy_10_spritepage
EndIf
 Next
End Function

;////////////////////////////
;/ Function to move Enemies /
;////////////////////////////
Function move_enemies()

If below_moon_surface=True

If enemy_1=True
	If ene_1_switchdown=True ; And below_moon_surface=True
	If ene_1_verpos < 446 Then ene_1_verpos=ene_1_verpos+1
	If ene_1_verpos => 446 Then ene_1_switchdown=False ene_1_switchup=True
	EndIf
	If ene_1_switchright=True ;And below_moon_surface=True
	If ene_1_horpos < 600 Then ene_1_horpos=ene_1_horpos+1
	If ene_1_horpos => 600 Then ene_1_switchright=False ene_1_switchleft=True
	EndIf
	If ene_1_switchup=True ;And below_moon_surface=True
	If ene_1_verpos > 90 Then ene_1_verpos=ene_1_verpos-1
	If ene_1_verpos =< 90 Then ene_1_switchup=False ene_1_switchdown=True
	EndIf
	If ene_1_switchleft=True ;And below_moon_surface=True
	If ene_1_horpos > 120 Then ene_1_horpos=ene_1_horpos-1
	If ene_1_horpos =< 120 Then ene_1_switchright=True ene_1_switchleft=False
	EndIf
EndIf

If enemy_2=True
	If ene_2_verpos < verpos Then ene_2_verpos=ene_2_verpos+1
	If ene_2_verpos > verpos Then ene_2_verpos=ene_2_verpos-1
	If ene_2_horpos < horpos Then ene_2_horpos=ene_2_horpos+1
	If ene_2_horpos > horpos Then ene_2_horpos=ene_2_horpos-1

	If ene_3_verpos < verpos Then ene_3_verpos=ene_3_verpos+1
	If ene_3_verpos > verpos Then ene_3_verpos=ene_3_verpos-1
	If ene_3_horpos < horpos Then ene_3_horpos=ene_3_horpos+1
	If ene_3_horpos > horpos Then ene_3_horpos=ene_3_horpos-1
EndIf

If enemy_7=True ;Fish
	If ene_7_switchdown=True ;446
	 If ene_7_verpos <  400 Then ene_7_verpos=ene_7_verpos+1 
	 If ene_7_verpos => 400 Then ene_7_switchdown=False ene_7_switchup=True flag_2=True ene_7_spritepage=124;98
	EndIf
	If ene_7_switchright=True ;600 ;500
	 If ene_7_horpos <  480 Then ene_7_horpos=ene_7_horpos+1
	 If ene_7_horpos => 480 Then ene_7_switchright=False ene_7_switchleft=True ene_7_spritepage=118;76
	EndIf
	If ene_7_switchup=True;90 ;250 
	 If ene_7_verpos >  200 Then ene_7_verpos=ene_7_verpos-1
	 If ene_7_verpos =< 200 Then ene_7_switchup=False ene_7_switchdown=True
	EndIf
	If ene_7_switchleft=True ;120 ;250
	 If ene_7_horpos >  280 Then ene_7_horpos=ene_7_horpos-1
	 If ene_7_horpos =< 280 Then ene_7_switchright=True ene_7_switchleft=False
	EndIf
EndIf

If enemy_8=True
	If ene_8_switchright=True
	 If ene_8_horpos < 650 Then ene_8_horpos=ene_8_horpos+1
	 If ene_8_horpos => 650 Then ene_8_switchleft=True ene_8_switchright=False flag_1=True ene_8_spritepage=98
	EndIf
	If ene_8_switchleft=True
	 If ene_8_horpos > 100 Then ene_8_horpos=ene_8_horpos-1
	 If ene_8_horpos =< 100 Then ene_8_switchleft=False ene_8_switchright=True ene_8_spritepage=76
	EndIf
	If ene_9_switchright=True
	 If ene_9_horpos < 650 Then ene_9_horpos=ene_9_horpos+1
	 If ene_9_horpos => 650 Then ene_9_switchleft=True ene_9_switchright=False
	EndIf
	If ene_9_switchleft=True
 	 If ene_9_horpos > 100 Then ene_9_horpos=ene_9_horpos-1
	 If ene_9_horpos =< 100 Then ene_9_switchleft=False ene_9_switchright=True
	EndIf
EndIf

EndIf
End Function

;//////////////////////////////
;/ Function to Draw the Stars /
;//////////////////////////////
Function animate_stars()
   For s.star = Each star
;	If MilliSecs()>earth_timer + 150 Then 
;	 earth_timer=MilliSecs()
;	 e\earth_spritepage=e\earth_spritepage+1
;	EndIf
   DrawImage (sprites),s\starhorpos,s\starverpos,s\star_spritepage
;  If e\earth_spritepage>157 Then e\earth_spritepage=154
 Next
End Function


;//////////////////////////////
;/ Function to delete enemies /
;//////////////////////////////
Function delete_enemies()
;	If deleted=False
	e.enemy = New enemy
	For e.enemy = Each enemy
	Delete e
	Next
;	deleted=True
;	EndIf
End Function
	
	
;//////////////////////////////////////////////
;/ Are we above_or_below_moon_surface check ? /
;//////////////////////////////////////////////
Function above_or_below_moon_surface()
	If below_moon_surface=False
;	 draw_stars() 
;	 animate_stars()
	 animate_earth_and_rocket()
	EndIf
End Function

;/////////////////////
;/ Game over check ? /
;/////////////////////
Function are_we_dead_yet()
	If falling=True
	 falling_counter=falling_counter+1
	EndIf
	If falling=False And falling_counter<250 Then ;200
 	 falling_counter=0
	EndIf
	If falling=False And falling_counter>250 Then ;200
	 falling_counter=0
 	 lost_live=True
	EndIf
	If lost_live=True Then 
	 lives=lives-1 
	 die_anim=True
	 lost_live=False
	EndIf ; falling_counter=0
	If lives=<0 And die_anim=False Then 
	game_reset() 
	game_on=False
	EndIf
End Function

;////////////////////////////
;/ Reset all when game over /
;////////////////////////////
Function game_reset()
	below_moon_surface=False
	reset_ledges()

;	For e.earth = Each earth
;	Delete e
;	Next
	For s.spaceman = Each spaceman
	Delete s
	Next
	alchiem_counter=0
	screen_counter=6
	verpos=400
	underground_down_screen_counter=0
	b_page=0
	verpos=400 ;580-64 ; on floor  100;verpos=>(580-64
	horpos=150;250
	verpos1=580-64	
	delete_enemies()
	u_screen_log=0
	
	
End Function