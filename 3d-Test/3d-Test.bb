Global x=150
Global y=3
Global z=250

Graphics3D 800,600,16,2
SetBuffer BackBuffer() 
camera=CreateCamera() 
light=CreateLight() 
RotateEntity light,90,0,0 

alien=LoadAnimMesh("media/Alien.b3d")
mesh_canyon = LoadMesh("media/test_ted.b3d")

RotateEntity light,90,0,0 
AmbientLight 90,90,90
light_sun = CreateLight(1)
LightColor light_sun,200,200,100
PositionEntity alien,x,y,z

; ---------------------------------------------------------------
; Attach camera to player...
; ---------------------------------------------------------------
PositionEntity camera, x, EntityY (alien) + 4.85, 220
EntityParent camera, alien

Animate alien,1

While Not KeyDown(1) 

 If KeyDown( 205 )=True Then 
  TurnEntity alien,0,1,0
 EndIf

 If KeyDown( 203 )=True Then 
  TurnEntity alien,0,-1,0
 EndIf
 
; Down
 If KeyDown( 208 )=True Then
  MoveEntity alien,0,0,-1.0
 EndIf

; Up
 If KeyDown( 200 )=True Then
  MoveEntity alien,0,0,1.0
 EndIf


 If KeyDown( 44 )=True Then
  RotateEntity alien,0,1.0,0
 EndIf

PointEntity camera, alien

UpdateWorld
RenderWorld

Text 220,000,Mid$("3d Test - written in 2007",True)
;Text 200,040,Mid$("X="+x,True)
;Text 250,040,Mid$("Y="+y,True)
;Text 300,040,Mid$("Z="+z,True)
Flip
Wend

End 