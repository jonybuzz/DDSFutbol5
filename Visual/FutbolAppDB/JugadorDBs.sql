CREATE TABLE [dbo].Jugador
(
	[Id] INT NOT NULL PRIMARY KEY IDENTITY, 
    [Nombre] NVARCHAR(50) NULL, 
    [Apodo] NVARCHAR(50) NULL, 
    [Fecha_nac] DATETIME NULL, 
    [Mail] NVARCHAR(50) NOT NULL UNIQUE, 
    [Handicap] NUMERIC NULL 
)
