ALTER TABLE [dbo].[UserProfile]
--ADD
--    [Username]    NVARCHAR (50) NULL,
--    [Apodo]     NVARCHAR (50) NULL,
--    [Fecha_nac] DATETIME      NULL,
--    [Mail]      NVARCHAR (50) NOT NULL DEFAULT 'MAIL',
--    [Handicap]  NUMERIC (18)  NULL,
--    UNIQUE NONCLUSTERED ([Mail] ASC),
--	  UNIQUE NONCLUSTERED (Username)

--GO
DROP CONSTRAINT "Mail"