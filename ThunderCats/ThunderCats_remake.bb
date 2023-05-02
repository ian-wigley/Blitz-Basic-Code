;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; Thundercats Intro Remake  ;
;    Blitz basic version    ;
;      written in 2007      ;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

Const SCREEN_WIDTH = 800
Const SCREEN_HEIGHT = 600

Graphics SCREEN_WIDTH,SCREEN_HEIGHT,16,2 ; maximum window size !
SetBuffer BackBuffer()

Global demo_go=False
Global mad$=""
Global txt$=0
Global scroll_text=0
Global scroll_pos=800
Global a=0
Global count
Global scroll_timer=0
Global intro_timer=0
Global up=True
Global down=False
Global bar_up=True
Global bar_down=False
Global line_count=0
Global z=0
Global r=22
Global fader_timer

;define the letters
Type letter
	Field logo_vertical_position
	Field logo_horizontal_position
	Field logo_spritepage
End Type

Const  number_of_stars = 100
Global stars=number_of_stars

;define star type
Type star_type0
	Field star_vertical_position0
	Field star_horizontal_position0
	Field star_spritepage0
End Type

;define star type
Type istar_type1
	Field istar_vertical_position1
	Field istar_horizontal_position1
	Field istar_spritepage1
End Type

Dim sinetable(360)
Global angle=0
Global angle1=0
Global startangle=0
Global fntcomic

For angle = 0 To 359
	sinetable(angle) = 50 * Sin(angle * 1.412) + 10
Next

initialise_fader_colours()

For i=0 To stars 		;Setup the stars with a loop
	Launchstars0()
	Launchstars1()
Next

For j=0 To 5			;Setup letters
	configureLetters()
Next

copyMessage()

fntcomic           = LoadFont("comic sans ms",72,True,False,False)
Global logo        = LoadImage("graphics\thundercats logo.png")
Global starz0      = LoadImage("graphics\star0.png")
Global starz1      = LoadImage("graphics\star0.png")
Global music       = PlayMusic("graphics\TC_music.mp3")
Global letterImage = LoadAnimImage("graphics\logo.png",52,52,0,4)

While Not KeyHit(1)
	Cls
	large_scroll()
	update_star_layer0()
	update_star_layer1()
	initialise_fader_colours()
	updateSineEffect()
	Color r,r,r
	Line 0,200,800,200
	Color r,r,r
	Line 0,400,800,400
	updateColourBar()
	Color r,r,255
	updateLetterPositions()
	Flip
Wend
FreeFont fntcomic
End

;//////////////////////////////////////////////////////////
;/ Function to copy scoll_message data into another array /
;//////////////////////////////////////////////////////////
Function copyMessage()
	Restore scroll_message
	While scroll_txt$ <> "*"
		Read scroll_txt$
		If scroll_txt$ <> "*" Then mad$ = mad$ + scroll_txt$
	Wend
End Function

.scroll_message
Data "  "
Data "Oh hello......   "
Data "   Anzax here with my first PC intro, this "
Data "was going to be a simple Remake of the original "
Data "Thundercats "
Data "intro that me & Craig put together back in "
Data "the good old C64 days..... but I chucked a couple of "
Data "other bits in to make it a little (?!!) more interesting !!!! "
Data "  The ThunderCats logo was borrowed from somewhere...  music by Rob Hubbard "
Data "converted from a lovely 5k into a monster mp3 !!      "
Data "Hello's go out to everyone....               "
Data " hit ESC to quit        Bye ........         "
Data "                  "
Data "*"

;////////////////////////////////////////////////
;/ Function to copy Fading colours into a array /
;////////////////////////////////////////////////
Function initialise_fader_colours()
	If up=True Then
		If MilliSecs()>fader_timer + 40 Then
			fader_timer=MilliSecs()
			r=r+11
		EndIf
		If r=>253 Then down=True up=False
	EndIf

	If down=True Then
		If MilliSecs()>fader_timer + 40 Then
			fader_timer=MilliSecs()
			r=r-11
		EndIf
		If r=<33 Then up=True down=False
	EndIf
End Function


;////////////////////////////
;/ Cheating scroll effect ! /
;////////////////////////////
Function large_scroll()
	SetFont fntcomic
	Text scroll_pos,count,Mid$(""+mad$,True)
	If a=40 Then a=0
	scroll_pos=scroll_pos-3
	If scroll_pos<-18000 Then scroll_pos=800
End Function

;/////////////////////////////////////
;/ Function to initalise each letter /
;/////////////////////////////////////
Function configureLetters()
	j.letter                   = New letter
	j\logo_vertical_position   = 460;Rand(040,540)
	j\logo_horizontal_position = 300;Rand(080,980)
	logo_spritepage            = 1
End Function

;///////////////////////////////
;/ Function to initalise stars /
;///////////////////////////////
Function launchstars0()
	s.star_type0                = New star_type0
	s\star_vertical_position0   = Rand(040,540)
	s\star_horizontal_position0 = Rand(080,980)
End Function

;///////////////////////////////
;/ Function to initalise stars /
;///////////////////////////////
Function launchstars1()
	i.istar_type1                = New istar_type1
	i\istar_vertical_position1   = Rand(040,540)
	i\istar_horizontal_position1 = Rand(080,980)
End Function

;////////////////////////////////////////
;/ Function to move all of the letters /
;///////////////////////////////////////
Function updateLetterPositions()
	For j.letter = Each letter  ;loop thro all of the letters
		DrawImage (letterImage),j\logo_horizontal_position+100-(count+52)/2,j\logo_vertical_position,j\logo_spritepage
		DrawImage (letterImage),j\logo_horizontal_position+152-(count+256)/4,j\logo_vertical_position,j\logo_spritepage+1
		DrawImage (letterImage),j\logo_horizontal_position+104,j\logo_vertical_position,j\logo_spritepage+2
		DrawImage (letterImage),j\logo_horizontal_position+120+(count)/4,j\logo_vertical_position,j\logo_spritepage
		DrawImage (letterImage),j\logo_horizontal_position+136+(count)/2,j\logo_vertical_position,j\logo_spritepage+3
	Next
End Function

;//////////////////////////////////////////////
;/ Function to move all of the stars (layer0) /
;//////////////////////////////////////////////
Function update_star_layer0()
	Color 55,55,55
	For s.star_type0 = Each star_type0
		s\star_horizontal_position0=s\star_horizontal_position0+1
		If s\star_horizontal_position0>800 Then
			s\star_horizontal_position0 = Rand(-350,-050)
			s\star_vertical_position0   = Rand(040,540)
		EndIf
		DrawImage (starz0),s\star_horizontal_position0,s\star_vertical_position0
	Next
End Function

;//////////////////////////////////////////////
;/ Function to move all of the stars (layer1) /
;//////////////////////////////////////////////
Function update_star_layer1()
	Color 55,55,55
	For i.istar_type1 = Each istar_type1
		i\istar_horizontal_position1=i\istar_horizontal_position1+2
		If i\istar_horizontal_position1>800 Then
			i\istar_horizontal_position1 = Rand(-350,-050)
			i\istar_vertical_position1   = Rand(040,540)
		EndIf
		DrawImage (starz1),i\istar_horizontal_position1,i\istar_vertical_position1
	Next
End Function

;/////////////////////////////////////
;/ Function to update the sin effect /
;/////////////////////////////////////
Function updateSineEffect()
	angle = startangle
	For y = 0 To 200;
		CopyRect 0, y, 640, 2, 200+sinetable(angle), y+x,ImageBuffer(logo), BackBuffer()
		angle = (angle + 1) And $ff
		count = sinetable(angle)+200+50
	Next
	startangle = startangle + 1 And $ff
	x=x+1 And $ff
	If x=80 Then x=0
End Function

;/////////////////////////////////////
;/ Function to display a copperbar ! /
;/////////////////////////////////////
Function updateColourBar()
	For y = 0 To 25
		Color y*10,0,y*10
		Line 0,count+200+y,800,count+200+y
	Next
	For y = 0 To 25
		Color 250-(y*10),0,250-(y*10)
		Line 0,count+200+y+25,800,count+200+y+25
	Next
End Function