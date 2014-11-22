
-- --------------------------------------------------
-- Entity Designer DDL Script for SQL Server 2005, 2008, 2012 and Azure
-- --------------------------------------------------
-- Date Created: 11/19/2014 14:27:16
-- Generated from EDMX file: C:\Users\user\git\DDS\Visual\Futbol5\Futbol5\Models\Model.edmx
-- --------------------------------------------------

SET QUOTED_IDENTIFIER OFF;
GO
USE [Futbol5Context-20141116164713];
GO
IF SCHEMA_ID(N'dbo') IS NULL EXECUTE(N'CREATE SCHEMA [dbo]');
GO

-- --------------------------------------------------
-- Dropping existing FOREIGN KEY constraints
-- --------------------------------------------------

IF OBJECT_ID(N'[dbo].[FK_AmigosJugador]', 'F') IS NOT NULL
    ALTER TABLE [dbo].[AmistadSet] DROP CONSTRAINT [FK_AmigosJugador];
GO
IF OBJECT_ID(N'[dbo].[FK_AmigosJugador1]', 'F') IS NOT NULL
    ALTER TABLE [dbo].[AmistadSet] DROP CONSTRAINT [FK_AmigosJugador1];
GO
IF OBJECT_ID(N'[dbo].[FK_CalificacionCalificado]', 'F') IS NOT NULL
    ALTER TABLE [dbo].[CalificacionSet] DROP CONSTRAINT [FK_CalificacionCalificado];
GO
IF OBJECT_ID(N'[dbo].[FK_CalificacionCalificador]', 'F') IS NOT NULL
    ALTER TABLE [dbo].[CalificacionSet] DROP CONSTRAINT [FK_CalificacionCalificador];
GO
IF OBJECT_ID(N'[dbo].[FK_CalificacionPartido]', 'F') IS NOT NULL
    ALTER TABLE [dbo].[CalificacionSet] DROP CONSTRAINT [FK_CalificacionPartido];
GO
IF OBJECT_ID(N'[dbo].[FK_EstadoPartidoPartido]', 'F') IS NOT NULL
    ALTER TABLE [dbo].[PartidoSet] DROP CONSTRAINT [FK_EstadoPartidoPartido];
GO
IF OBJECT_ID(N'[dbo].[FK_InfraccionJugador]', 'F') IS NOT NULL
    ALTER TABLE [dbo].[InfraccionSet] DROP CONSTRAINT [FK_InfraccionJugador];
GO
IF OBJECT_ID(N'[dbo].[FK_InscripcionJugador]', 'F') IS NOT NULL
    ALTER TABLE [dbo].[InscripcionSet] DROP CONSTRAINT [FK_InscripcionJugador];
GO
IF OBJECT_ID(N'[dbo].[FK_InscripcionPartido]', 'F') IS NOT NULL
    ALTER TABLE [dbo].[InscripcionSet] DROP CONSTRAINT [FK_InscripcionPartido];
GO
IF OBJECT_ID(N'[dbo].[FK_TipoInscripcionInscripcion]', 'F') IS NOT NULL
    ALTER TABLE [dbo].[InscripcionSet] DROP CONSTRAINT [FK_TipoInscripcionInscripcion];
GO

-- --------------------------------------------------
-- Dropping existing tables
-- --------------------------------------------------

IF OBJECT_ID(N'[dbo].[AmistadSet]', 'U') IS NOT NULL
    DROP TABLE [dbo].[AmistadSet];
GO
IF OBJECT_ID(N'[dbo].[CalificacionSet]', 'U') IS NOT NULL
    DROP TABLE [dbo].[CalificacionSet];
GO
IF OBJECT_ID(N'[dbo].[EstadoPartidoSet]', 'U') IS NOT NULL
    DROP TABLE [dbo].[EstadoPartidoSet];
GO
IF OBJECT_ID(N'[dbo].[InfraccionSet]', 'U') IS NOT NULL
    DROP TABLE [dbo].[InfraccionSet];
GO
IF OBJECT_ID(N'[dbo].[InscripcionSet]', 'U') IS NOT NULL
    DROP TABLE [dbo].[InscripcionSet];
GO
IF OBJECT_ID(N'[dbo].[JugadorSet]', 'U') IS NOT NULL
    DROP TABLE [dbo].[JugadorSet];
GO
IF OBJECT_ID(N'[dbo].[PartidoSet]', 'U') IS NOT NULL
    DROP TABLE [dbo].[PartidoSet];
GO
IF OBJECT_ID(N'[dbo].[TipoInscripcionSet]', 'U') IS NOT NULL
    DROP TABLE [dbo].[TipoInscripcionSet];
GO

-- --------------------------------------------------
-- Creating all tables
-- --------------------------------------------------

-- Creating table 'JugadorSet'
CREATE TABLE [dbo].[JugadorSet] (
    [Id] int IDENTITY(1,1) NOT NULL,
    [Nombre] nvarchar(max)  NOT NULL,
    [Apodo] nvarchar(max)  NULL,
    [Fecha_Nac] datetime  NOT NULL,
    [Mail] nvarchar(max)  NULL,
    [Handicap] int  NULL
);
GO

-- Creating table 'PartidoSet'
CREATE TABLE [dbo].[PartidoSet] (
    [Id] int IDENTITY(1,1) NOT NULL,
    [Fecha] datetime  NOT NULL,
    [Administrador] nvarchar(max)  NOT NULL,
    [EstadoPartidoId] int  NOT NULL
);
GO

-- Creating table 'InscripcionSet'
CREATE TABLE [dbo].[InscripcionSet] (
    [Id] int IDENTITY(1,1) NOT NULL,
    [PartidoId] int  NOT NULL,
    [JugadorId] int  NOT NULL,
    [TipoInscripcionId] int  NOT NULL,
    [Comentario] nvarchar(max)  NULL,
    [EquipoId] int  NULL
);
GO

-- Creating table 'CalificacionSet'
CREATE TABLE [dbo].[CalificacionSet] (
    [Id] int IDENTITY(1,1) NOT NULL,
    [Nota] int  NOT NULL,
    [Comentario] nvarchar(max)  NULL,
    [JugadorCalificadorId] int  NOT NULL,
    [JugadorCalificadoId] int  NOT NULL,
    [PartidoId] int  NOT NULL
);
GO

-- Creating table 'EstadoPartidoSet'
CREATE TABLE [dbo].[EstadoPartidoSet] (
    [Id] int IDENTITY(1,1) NOT NULL,
    [Descripcion] nvarchar(max)  NOT NULL
);
GO

-- Creating table 'InfraccionSet'
CREATE TABLE [dbo].[InfraccionSet] (
    [Id] int IDENTITY(1,1) NOT NULL,
    [Fecha] nvarchar(max)  NOT NULL,
    [Motivo] nvarchar(max)  NOT NULL,
    [JugadorId] int  NOT NULL
);
GO

-- Creating table 'AmistadSet'
CREATE TABLE [dbo].[AmistadSet] (
    [Id] int IDENTITY(1,1) NOT NULL,
    [JugadorId] int  NULL,
    [JugadorId1] int  NULL
);
GO

-- Creating table 'TipoInscripcionSet'
CREATE TABLE [dbo].[TipoInscripcionSet] (
    [Id] int IDENTITY(1,1) NOT NULL,
    [Descripcion] nvarchar(max)  NOT NULL
);
GO

-- Creating table 'EquipoSet'
CREATE TABLE [dbo].[EquipoSet] (
    [Id] int IDENTITY(1,1) NOT NULL,
    [PartidoId] int  NOT NULL
);
GO

-- --------------------------------------------------
-- Creating all PRIMARY KEY constraints
-- --------------------------------------------------

-- Creating primary key on [Id] in table 'JugadorSet'
ALTER TABLE [dbo].[JugadorSet]
ADD CONSTRAINT [PK_JugadorSet]
    PRIMARY KEY CLUSTERED ([Id] ASC);
GO

-- Creating primary key on [Id] in table 'PartidoSet'
ALTER TABLE [dbo].[PartidoSet]
ADD CONSTRAINT [PK_PartidoSet]
    PRIMARY KEY CLUSTERED ([Id] ASC);
GO

-- Creating primary key on [Id] in table 'InscripcionSet'
ALTER TABLE [dbo].[InscripcionSet]
ADD CONSTRAINT [PK_InscripcionSet]
    PRIMARY KEY CLUSTERED ([Id] ASC);
GO

-- Creating primary key on [Id] in table 'CalificacionSet'
ALTER TABLE [dbo].[CalificacionSet]
ADD CONSTRAINT [PK_CalificacionSet]
    PRIMARY KEY CLUSTERED ([Id] ASC);
GO

-- Creating primary key on [Id] in table 'EstadoPartidoSet'
ALTER TABLE [dbo].[EstadoPartidoSet]
ADD CONSTRAINT [PK_EstadoPartidoSet]
    PRIMARY KEY CLUSTERED ([Id] ASC);
GO

-- Creating primary key on [Id] in table 'InfraccionSet'
ALTER TABLE [dbo].[InfraccionSet]
ADD CONSTRAINT [PK_InfraccionSet]
    PRIMARY KEY CLUSTERED ([Id] ASC);
GO

-- Creating primary key on [Id] in table 'AmistadSet'
ALTER TABLE [dbo].[AmistadSet]
ADD CONSTRAINT [PK_AmistadSet]
    PRIMARY KEY CLUSTERED ([Id] ASC);
GO

-- Creating primary key on [Id] in table 'TipoInscripcionSet'
ALTER TABLE [dbo].[TipoInscripcionSet]
ADD CONSTRAINT [PK_TipoInscripcionSet]
    PRIMARY KEY CLUSTERED ([Id] ASC);
GO

-- Creating primary key on [Id] in table 'EquipoSet'
ALTER TABLE [dbo].[EquipoSet]
ADD CONSTRAINT [PK_EquipoSet]
    PRIMARY KEY CLUSTERED ([Id] ASC);
GO

-- --------------------------------------------------
-- Creating all FOREIGN KEY constraints
-- --------------------------------------------------

-- Creating foreign key on [PartidoId] in table 'InscripcionSet'
ALTER TABLE [dbo].[InscripcionSet]
ADD CONSTRAINT [FK_InscripcionPartido]
    FOREIGN KEY ([PartidoId])
    REFERENCES [dbo].[PartidoSet]
        ([Id])
    ON DELETE NO ACTION ON UPDATE NO ACTION;
GO

-- Creating non-clustered index for FOREIGN KEY 'FK_InscripcionPartido'
CREATE INDEX [IX_FK_InscripcionPartido]
ON [dbo].[InscripcionSet]
    ([PartidoId]);
GO

-- Creating foreign key on [JugadorId] in table 'InscripcionSet'
ALTER TABLE [dbo].[InscripcionSet]
ADD CONSTRAINT [FK_InscripcionJugador]
    FOREIGN KEY ([JugadorId])
    REFERENCES [dbo].[JugadorSet]
        ([Id])
    ON DELETE NO ACTION ON UPDATE NO ACTION;
GO

-- Creating non-clustered index for FOREIGN KEY 'FK_InscripcionJugador'
CREATE INDEX [IX_FK_InscripcionJugador]
ON [dbo].[InscripcionSet]
    ([JugadorId]);
GO

-- Creating foreign key on [JugadorCalificadorId] in table 'CalificacionSet'
ALTER TABLE [dbo].[CalificacionSet]
ADD CONSTRAINT [FK_CalificacionCalificador]
    FOREIGN KEY ([JugadorCalificadorId])
    REFERENCES [dbo].[JugadorSet]
        ([Id])
    ON DELETE NO ACTION ON UPDATE NO ACTION;
GO

-- Creating non-clustered index for FOREIGN KEY 'FK_CalificacionCalificador'
CREATE INDEX [IX_FK_CalificacionCalificador]
ON [dbo].[CalificacionSet]
    ([JugadorCalificadorId]);
GO

-- Creating foreign key on [JugadorCalificadoId] in table 'CalificacionSet'
ALTER TABLE [dbo].[CalificacionSet]
ADD CONSTRAINT [FK_CalificacionCalificado]
    FOREIGN KEY ([JugadorCalificadoId])
    REFERENCES [dbo].[JugadorSet]
        ([Id])
    ON DELETE NO ACTION ON UPDATE NO ACTION;
GO

-- Creating non-clustered index for FOREIGN KEY 'FK_CalificacionCalificado'
CREATE INDEX [IX_FK_CalificacionCalificado]
ON [dbo].[CalificacionSet]
    ([JugadorCalificadoId]);
GO

-- Creating foreign key on [PartidoId] in table 'CalificacionSet'
ALTER TABLE [dbo].[CalificacionSet]
ADD CONSTRAINT [FK_CalificacionPartido]
    FOREIGN KEY ([PartidoId])
    REFERENCES [dbo].[PartidoSet]
        ([Id])
    ON DELETE NO ACTION ON UPDATE NO ACTION;
GO

-- Creating non-clustered index for FOREIGN KEY 'FK_CalificacionPartido'
CREATE INDEX [IX_FK_CalificacionPartido]
ON [dbo].[CalificacionSet]
    ([PartidoId]);
GO

-- Creating foreign key on [EstadoPartidoId] in table 'PartidoSet'
ALTER TABLE [dbo].[PartidoSet]
ADD CONSTRAINT [FK_EstadoPartidoPartido]
    FOREIGN KEY ([EstadoPartidoId])
    REFERENCES [dbo].[EstadoPartidoSet]
        ([Id])
    ON DELETE NO ACTION ON UPDATE NO ACTION;
GO

-- Creating non-clustered index for FOREIGN KEY 'FK_EstadoPartidoPartido'
CREATE INDEX [IX_FK_EstadoPartidoPartido]
ON [dbo].[PartidoSet]
    ([EstadoPartidoId]);
GO

-- Creating foreign key on [JugadorId] in table 'InfraccionSet'
ALTER TABLE [dbo].[InfraccionSet]
ADD CONSTRAINT [FK_InfraccionJugador]
    FOREIGN KEY ([JugadorId])
    REFERENCES [dbo].[JugadorSet]
        ([Id])
    ON DELETE NO ACTION ON UPDATE NO ACTION;
GO

-- Creating non-clustered index for FOREIGN KEY 'FK_InfraccionJugador'
CREATE INDEX [IX_FK_InfraccionJugador]
ON [dbo].[InfraccionSet]
    ([JugadorId]);
GO

-- Creating foreign key on [JugadorId] in table 'AmistadSet'
ALTER TABLE [dbo].[AmistadSet]
ADD CONSTRAINT [FK_AmigosJugador]
    FOREIGN KEY ([JugadorId])
    REFERENCES [dbo].[JugadorSet]
        ([Id])
    ON DELETE NO ACTION ON UPDATE NO ACTION;
GO

-- Creating non-clustered index for FOREIGN KEY 'FK_AmigosJugador'
CREATE INDEX [IX_FK_AmigosJugador]
ON [dbo].[AmistadSet]
    ([JugadorId]);
GO

-- Creating foreign key on [JugadorId1] in table 'AmistadSet'
ALTER TABLE [dbo].[AmistadSet]
ADD CONSTRAINT [FK_AmigosJugador1]
    FOREIGN KEY ([JugadorId1])
    REFERENCES [dbo].[JugadorSet]
        ([Id])
    ON DELETE NO ACTION ON UPDATE NO ACTION;
GO

-- Creating non-clustered index for FOREIGN KEY 'FK_AmigosJugador1'
CREATE INDEX [IX_FK_AmigosJugador1]
ON [dbo].[AmistadSet]
    ([JugadorId1]);
GO

-- Creating foreign key on [TipoInscripcionId] in table 'InscripcionSet'
ALTER TABLE [dbo].[InscripcionSet]
ADD CONSTRAINT [FK_TipoInscripcionInscripcion]
    FOREIGN KEY ([TipoInscripcionId])
    REFERENCES [dbo].[TipoInscripcionSet]
        ([Id])
    ON DELETE NO ACTION ON UPDATE NO ACTION;
GO

-- Creating non-clustered index for FOREIGN KEY 'FK_TipoInscripcionInscripcion'
CREATE INDEX [IX_FK_TipoInscripcionInscripcion]
ON [dbo].[InscripcionSet]
    ([TipoInscripcionId]);
GO

-- Creating foreign key on [EquipoId] in table 'InscripcionSet'
ALTER TABLE [dbo].[InscripcionSet]
ADD CONSTRAINT [FK_EquipoInscripcion]
    FOREIGN KEY ([EquipoId])
    REFERENCES [dbo].[EquipoSet]
        ([Id])
    ON DELETE NO ACTION ON UPDATE NO ACTION;
GO

-- Creating non-clustered index for FOREIGN KEY 'FK_EquipoInscripcion'
CREATE INDEX [IX_FK_EquipoInscripcion]
ON [dbo].[InscripcionSet]
    ([EquipoId]);
GO

-- Creating foreign key on [PartidoId] in table 'EquipoSet'
ALTER TABLE [dbo].[EquipoSet]
ADD CONSTRAINT [FK_EquipoPartido]
    FOREIGN KEY ([PartidoId])
    REFERENCES [dbo].[PartidoSet]
        ([Id])
    ON DELETE NO ACTION ON UPDATE NO ACTION;
GO

-- Creating non-clustered index for FOREIGN KEY 'FK_EquipoPartido'
CREATE INDEX [IX_FK_EquipoPartido]
ON [dbo].[EquipoSet]
    ([PartidoId]);
GO

-- --------------------------------------------------
-- Script has ended
-- --------------------------------------------------