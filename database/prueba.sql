USE [prueba]
GO
/****** Object:  Table [dbo].[book]    Script Date: 2/28/2021 2:13:45 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[book](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[nombre] [varchar](150) NULL,
	[descripcion] [varchar](300) NOT NULL,
	[autor] [varchar](150) NOT NULL,
	[fecha_pub] [date] NOT NULL,
	[num_ejem] [int] NOT NULL,
	[costo] [decimal](8, 4) NOT NULL,
 CONSTRAINT [PK_book] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[book] ON 

INSERT [dbo].[book] ([id], [nombre], [descripcion], [autor], [fecha_pub], [num_ejem], [costo]) VALUES (1, N'Quijote de la mancha', N'Libro mas leido', N'Miguel C.', CAST(N'1950-01-01' AS Date), 50, CAST(30.0000 AS Decimal(8, 4)))
INSERT [dbo].[book] ([id], [nombre], [descripcion], [autor], [fecha_pub], [num_ejem], [costo]) VALUES (3, N'Ahora es Digital', N'Este  si se actualizo', N'DYDY', CAST(N'2020-04-25' AS Date), 15, CAST(11.0000 AS Decimal(8, 4)))
INSERT [dbo].[book] ([id], [nombre], [descripcion], [autor], [fecha_pub], [num_ejem], [costo]) VALUES (6, N'Cumanda', N'nombre de una heroína de aquellas desiertas regiones', N'Juan Leon Mera', CAST(N'2021-02-26' AS Date), 5, CAST(15.5000 AS Decimal(8, 4)))
INSERT [dbo].[book] ([id], [nombre], [descripcion], [autor], [fecha_pub], [num_ejem], [costo]) VALUES (7, N'Emancipada', N'La emancipada es una novela corta del escritor ecuatoriano Miguel Riofrío, publicada por primera vez en 1863 en el diario quiteño "La Unión".? Es considerada como la primera novela publicada en Ecuado', N'Miguel Rio frio', CAST(N'1987-02-09' AS Date), 100, CAST(23.0000 AS Decimal(8, 4)))
INSERT [dbo].[book] ([id], [nombre], [descripcion], [autor], [fecha_pub], [num_ejem], [costo]) VALUES (8, N'Huasipungo', N'Libro antiguo', N'Jorge Icaza', CAST(N'2007-02-27' AS Date), 100, CAST(50.5500 AS Decimal(8, 4)))
INSERT [dbo].[book] ([id], [nombre], [descripcion], [autor], [fecha_pub], [num_ejem], [costo]) VALUES (9, N'El Chulla Romero', N'Es una de las obras más traducidas de este autor, y figura entre las más importantes de su obra', N'Jorge Icaza', CAST(N'1958-12-04' AS Date), 50, CAST(20.0000 AS Decimal(8, 4)))
INSERT [dbo].[book] ([id], [nombre], [descripcion], [autor], [fecha_pub], [num_ejem], [costo]) VALUES (10, N'Maria Jesus', N'', N'Medaro Angel Silva', CAST(N'2017-02-13' AS Date), 50, CAST(30.8500 AS Decimal(8, 4)))
INSERT [dbo].[book] ([id], [nombre], [descripcion], [autor], [fecha_pub], [num_ejem], [costo]) VALUES (11, N'A la Costa', N'', N'Luis Alfredo Martinez', CAST(N'1950-11-04' AS Date), 10, CAST(20.0000 AS Decimal(8, 4)))
INSERT [dbo].[book] ([id], [nombre], [descripcion], [autor], [fecha_pub], [num_ejem], [costo]) VALUES (12, N'Las Catalinarias', N'', N'Juan Montalvo', CAST(N'2013-02-03' AS Date), 50, CAST(40.0000 AS Decimal(8, 4)))
INSERT [dbo].[book] ([id], [nombre], [descripcion], [autor], [fecha_pub], [num_ejem], [costo]) VALUES (13, N'El camino del sol', N'', N'Jorge Carrera Andrade', CAST(N'2019-07-16' AS Date), 70, CAST(15.9800 AS Decimal(8, 4)))
INSERT [dbo].[book] ([id], [nombre], [descripcion], [autor], [fecha_pub], [num_ejem], [costo]) VALUES (14, N'Odisea', N'', N'Homero', CAST(N'2021-02-16' AS Date), 50, CAST(90.0000 AS Decimal(8, 4)))
INSERT [dbo].[book] ([id], [nombre], [descripcion], [autor], [fecha_pub], [num_ejem], [costo]) VALUES (15, N'Cien años de soledad ', N'', N'Gabriel G. Marquez.', CAST(N'1966-12-31' AS Date), 100, CAST(50.0000 AS Decimal(8, 4)))
SET IDENTITY_INSERT [dbo].[book] OFF
