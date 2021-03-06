USE [master]
GO

/****** Object:  Database [Mantech]    Script Date: 10/08/2012 14:36:39 ******/
CREATE DATABASE [Mantech] ON  PRIMARY 
( NAME = N'Mantech', FILENAME = N'C:\MantechDB\Mantech.mdf' , SIZE = 2048KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'Mantech_log', FILENAME = N'C:\MantechDB\Mantech_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO

ALTER DATABASE [Mantech] SET COMPATIBILITY_LEVEL = 100
GO

IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [Mantech].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO

ALTER DATABASE [Mantech] SET ANSI_NULL_DEFAULT OFF 
GO

ALTER DATABASE [Mantech] SET ANSI_NULLS OFF 
GO

ALTER DATABASE [Mantech] SET ANSI_PADDING OFF 
GO

ALTER DATABASE [Mantech] SET ANSI_WARNINGS OFF 
GO

ALTER DATABASE [Mantech] SET ARITHABORT OFF 
GO

ALTER DATABASE [Mantech] SET AUTO_CLOSE OFF 
GO

ALTER DATABASE [Mantech] SET AUTO_CREATE_STATISTICS ON 
GO

ALTER DATABASE [Mantech] SET AUTO_SHRINK OFF 
GO

ALTER DATABASE [Mantech] SET AUTO_UPDATE_STATISTICS ON 
GO

ALTER DATABASE [Mantech] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO

ALTER DATABASE [Mantech] SET CURSOR_DEFAULT  GLOBAL 
GO

ALTER DATABASE [Mantech] SET CONCAT_NULL_YIELDS_NULL OFF 
GO

ALTER DATABASE [Mantech] SET NUMERIC_ROUNDABORT OFF 
GO

ALTER DATABASE [Mantech] SET QUOTED_IDENTIFIER OFF 
GO

ALTER DATABASE [Mantech] SET RECURSIVE_TRIGGERS OFF 
GO

ALTER DATABASE [Mantech] SET  DISABLE_BROKER 
GO

ALTER DATABASE [Mantech] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO

ALTER DATABASE [Mantech] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO

ALTER DATABASE [Mantech] SET TRUSTWORTHY OFF 
GO

ALTER DATABASE [Mantech] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO

ALTER DATABASE [Mantech] SET PARAMETERIZATION SIMPLE 
GO

ALTER DATABASE [Mantech] SET READ_COMMITTED_SNAPSHOT OFF 
GO

ALTER DATABASE [Mantech] SET HONOR_BROKER_PRIORITY OFF 
GO

ALTER DATABASE [Mantech] SET  READ_WRITE 
GO

ALTER DATABASE [Mantech] SET RECOVERY FULL 
GO

ALTER DATABASE [Mantech] SET  MULTI_USER 
GO

ALTER DATABASE [Mantech] SET PAGE_VERIFY CHECKSUM  
GO

ALTER DATABASE [Mantech] SET DB_CHAINING OFF 
GO


USE [Mantech]
GO
/****** Object:  Table [dbo].[Category]    Script Date: 10/08/2012 14:35:33 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Category](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](50) NOT NULL,
	[Description] [nvarchar](500) NULL,
 CONSTRAINT [PK_Category] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Article]    Script Date: 10/08/2012 14:35:33 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Article](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[Article] [nvarchar](50) NOT NULL,
	[Content] [text] NOT NULL,
	[CreatedDate] [date] NOT NULL,
	[Rate] [int] NULL,
	[Thumbnail] [nvarchar](50) NULL,
 CONSTRAINT [PK_Article] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[FAQ]    Script Date: 10/08/2012 14:35:33 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[FAQ](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[Question] [text] NOT NULL,
	[Answer] [text] NOT NULL,
 CONSTRAINT [PK_FAQ] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Department]    Script Date: 10/08/2012 14:35:33 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Department](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](50) NOT NULL,
	[Location] [nvarchar](1000) NULL,
 CONSTRAINT [PK_Department] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Technician]    Script Date: 10/08/2012 14:35:33 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Technician](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](50) NOT NULL,
	[Address] [nvarchar](100) NULL,
	[Telephone] [varchar](15) NOT NULL,
	[Image] [nvarchar](50) NULL,
 CONSTRAINT [PK_Technician] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Role]    Script Date: 10/08/2012 14:35:33 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Role](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[Role] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_Role] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Profile]    Script Date: 10/08/2012 14:35:33 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Profile](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[FullName] [nvarchar](100) NOT NULL,
	[Address] [nvarchar](500) NULL,
	[Email] [nvarchar](50) NOT NULL,
	[Telephone] [varchar](15) NOT NULL,
	[DepartmentID] [int] NOT NULL,
	[Image] [nvarchar](50) NULL,
 CONSTRAINT [PK_Profile] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Complaint]    Script Date: 10/08/2012 14:35:33 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Complaint](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[CategoryID] [int] NOT NULL,
	[ProfileID] [int] NOT NULL,
	[CreatedDate] [date] NOT NULL,
	[Issued] [bit] NOT NULL,
	[Pending] [bit] NOT NULL,
	[Completed] [bit] NOT NULL,
	[CompletedDate] [date] NULL,
	[TechnicianID] [int] NULL,
	[Note] [nvarchar](1000) NULL,
 CONSTRAINT [PK_Complaint] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Account]    Script Date: 10/08/2012 14:35:33 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Account](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[Username] [nvarchar](50) NOT NULL,
	[Password] [nvarchar](50) NOT NULL,
	[RoleID] [int] NOT NULL,
	[ProfileID] [int] NOT NULL,
 CONSTRAINT [PK_Account] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  View [dbo].[RTechnician]    Script Date: 10/08/2012 14:35:34 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE VIEW [dbo].[RTechnician]
AS
SELECT     dbo.Technician.Name AS Technician, dbo.Complaint.CreatedDate, dbo.Complaint.CompletedDate, dbo.Profile.FullName, dbo.Category.Name AS Category
FROM         dbo.Technician INNER JOIN
                      dbo.Complaint ON dbo.Technician.ID = dbo.Complaint.TechnicianID INNER JOIN
                      dbo.Profile ON dbo.Complaint.ProfileID = dbo.Profile.ID INNER JOIN
                      dbo.Category ON dbo.Complaint.CategoryID = dbo.Category.ID
GO
EXEC sys.sp_addextendedproperty @name=N'MS_DiagramPane1', @value=N'[0E232FF0-B466-11cf-A24F-00AA00A3EFFF, 1.00]
Begin DesignProperties = 
   Begin PaneConfigurations = 
      Begin PaneConfiguration = 0
         NumPanes = 4
         Configuration = "(H (1[40] 4[20] 2[20] 3) )"
      End
      Begin PaneConfiguration = 1
         NumPanes = 3
         Configuration = "(H (1 [50] 4 [25] 3))"
      End
      Begin PaneConfiguration = 2
         NumPanes = 3
         Configuration = "(H (1 [50] 2 [25] 3))"
      End
      Begin PaneConfiguration = 3
         NumPanes = 3
         Configuration = "(H (4 [30] 2 [40] 3))"
      End
      Begin PaneConfiguration = 4
         NumPanes = 2
         Configuration = "(H (1 [56] 3))"
      End
      Begin PaneConfiguration = 5
         NumPanes = 2
         Configuration = "(H (2 [66] 3))"
      End
      Begin PaneConfiguration = 6
         NumPanes = 2
         Configuration = "(H (4 [50] 3))"
      End
      Begin PaneConfiguration = 7
         NumPanes = 1
         Configuration = "(V (3))"
      End
      Begin PaneConfiguration = 8
         NumPanes = 3
         Configuration = "(H (1[56] 4[18] 2) )"
      End
      Begin PaneConfiguration = 9
         NumPanes = 2
         Configuration = "(H (1 [75] 4))"
      End
      Begin PaneConfiguration = 10
         NumPanes = 2
         Configuration = "(H (1[66] 2) )"
      End
      Begin PaneConfiguration = 11
         NumPanes = 2
         Configuration = "(H (4 [60] 2))"
      End
      Begin PaneConfiguration = 12
         NumPanes = 1
         Configuration = "(H (1) )"
      End
      Begin PaneConfiguration = 13
         NumPanes = 1
         Configuration = "(V (4))"
      End
      Begin PaneConfiguration = 14
         NumPanes = 1
         Configuration = "(V (2))"
      End
      ActivePaneConfig = 0
   End
   Begin DiagramPane = 
      Begin Origin = 
         Top = 0
         Left = 0
      End
      Begin Tables = 
         Begin Table = "Technician"
            Begin Extent = 
               Top = 6
               Left = 38
               Bottom = 125
               Right = 198
            End
            DisplayFlags = 280
            TopColumn = 0
         End
         Begin Table = "Complaint"
            Begin Extent = 
               Top = 6
               Left = 236
               Bottom = 125
               Right = 399
            End
            DisplayFlags = 280
            TopColumn = 0
         End
         Begin Table = "Profile"
            Begin Extent = 
               Top = 6
               Left = 437
               Bottom = 125
               Right = 597
            End
            DisplayFlags = 280
            TopColumn = 3
         End
         Begin Table = "Category"
            Begin Extent = 
               Top = 6
               Left = 635
               Bottom = 110
               Right = 795
            End
            DisplayFlags = 280
            TopColumn = 0
         End
      End
   End
   Begin SQLPane = 
   End
   Begin DataPane = 
      Begin ParameterDefaults = ""
      End
   End
   Begin CriteriaPane = 
      Begin ColumnWidths = 11
         Column = 1440
         Alias = 900
         Table = 1170
         Output = 720
         Append = 1400
         NewValue = 1170
         SortType = 1350
         SortOrder = 1410
         GroupBy = 1350
         Filter = 1350
         Or = 1350
         Or = 1350
         Or = 1350
      End
   End
End
' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'VIEW',@level1name=N'RTechnician'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_DiagramPaneCount', @value=1 , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'VIEW',@level1name=N'RTechnician'
GO
/****** Object:  View [dbo].[RDetail]    Script Date: 10/08/2012 14:35:34 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE VIEW [dbo].[RDetail]
AS
SELECT     dbo.Complaint.ID, dbo.Complaint.CreatedDate, dbo.Complaint.Issued, dbo.Complaint.Pending, dbo.Complaint.Completed, dbo.Complaint.CompletedDate, 
                      dbo.Complaint.Note, dbo.Category.Name AS Category, dbo.Technician.Name AS Technician, dbo.Profile.FullName AS Employee, 
                      dbo.Department.Name AS Department
FROM         dbo.Complaint INNER JOIN
                      dbo.Category ON dbo.Complaint.CategoryID = dbo.Category.ID INNER JOIN
                      dbo.Technician ON dbo.Complaint.TechnicianID = dbo.Technician.ID INNER JOIN
                      dbo.Profile ON dbo.Complaint.ProfileID = dbo.Profile.ID INNER JOIN
                      dbo.Department ON dbo.Profile.DepartmentID = dbo.Department.ID
GO
EXEC sys.sp_addextendedproperty @name=N'MS_DiagramPane1', @value=N'[0E232FF0-B466-11cf-A24F-00AA00A3EFFF, 1.00]
Begin DesignProperties = 
   Begin PaneConfigurations = 
      Begin PaneConfiguration = 0
         NumPanes = 4
         Configuration = "(H (1[40] 4[20] 2[20] 3) )"
      End
      Begin PaneConfiguration = 1
         NumPanes = 3
         Configuration = "(H (1 [50] 4 [25] 3))"
      End
      Begin PaneConfiguration = 2
         NumPanes = 3
         Configuration = "(H (1 [50] 2 [25] 3))"
      End
      Begin PaneConfiguration = 3
         NumPanes = 3
         Configuration = "(H (4 [30] 2 [40] 3))"
      End
      Begin PaneConfiguration = 4
         NumPanes = 2
         Configuration = "(H (1 [56] 3))"
      End
      Begin PaneConfiguration = 5
         NumPanes = 2
         Configuration = "(H (2 [66] 3))"
      End
      Begin PaneConfiguration = 6
         NumPanes = 2
         Configuration = "(H (4 [50] 3))"
      End
      Begin PaneConfiguration = 7
         NumPanes = 1
         Configuration = "(V (3))"
      End
      Begin PaneConfiguration = 8
         NumPanes = 3
         Configuration = "(H (1[56] 4[18] 2) )"
      End
      Begin PaneConfiguration = 9
         NumPanes = 2
         Configuration = "(H (1 [75] 4))"
      End
      Begin PaneConfiguration = 10
         NumPanes = 2
         Configuration = "(H (1[66] 2) )"
      End
      Begin PaneConfiguration = 11
         NumPanes = 2
         Configuration = "(H (4 [60] 2))"
      End
      Begin PaneConfiguration = 12
         NumPanes = 1
         Configuration = "(H (1) )"
      End
      Begin PaneConfiguration = 13
         NumPanes = 1
         Configuration = "(V (4))"
      End
      Begin PaneConfiguration = 14
         NumPanes = 1
         Configuration = "(V (2))"
      End
      ActivePaneConfig = 0
   End
   Begin DiagramPane = 
      Begin Origin = 
         Top = 0
         Left = 0
      End
      Begin Tables = 
         Begin Table = "Complaint"
            Begin Extent = 
               Top = 6
               Left = 38
               Bottom = 220
               Right = 201
            End
            DisplayFlags = 280
            TopColumn = 0
         End
         Begin Table = "Category"
            Begin Extent = 
               Top = 6
               Left = 239
               Bottom = 110
               Right = 399
            End
            DisplayFlags = 280
            TopColumn = 0
         End
         Begin Table = "Technician"
            Begin Extent = 
               Top = 6
               Left = 437
               Bottom = 125
               Right = 597
            End
            DisplayFlags = 280
            TopColumn = 0
         End
         Begin Table = "Profile"
            Begin Extent = 
               Top = 25
               Left = 651
               Bottom = 144
               Right = 811
            End
            DisplayFlags = 280
            TopColumn = 0
         End
         Begin Table = "Department"
            Begin Extent = 
               Top = 114
               Left = 239
               Bottom = 218
               Right = 399
            End
            DisplayFlags = 280
            TopColumn = 0
         End
      End
   End
   Begin SQLPane = 
   End
   Begin DataPane = 
      Begin ParameterDefaults = ""
      End
   End
   Begin CriteriaPane = 
      Begin ColumnWidths = 11
         Column = 1440
         Alias = 975
         Table = 1170
         Output = 720
         Append = 1400
         NewValue = 1170
         SortType = 1350
         SortOrder = 1410
         GroupBy = 1350
         Filter = 1350
         Or = 1350
         Or = 1350
         O' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'VIEW',@level1name=N'RDetail'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_DiagramPane2', @value=N'r = 1350
      End
   End
End
' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'VIEW',@level1name=N'RDetail'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_DiagramPaneCount', @value=2 , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'VIEW',@level1name=N'RDetail'
GO
/****** Object:  View [dbo].[RDepartment]    Script Date: 10/08/2012 14:35:34 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE VIEW [dbo].[RDepartment]
AS
SELECT     dbo.Department.Name AS Department, dbo.Profile.FullName, dbo.Complaint.CreatedDate, dbo.Complaint.CompletedDate, dbo.Category.Name AS Category, 
                      dbo.Technician.Name AS Technician
FROM         dbo.Department INNER JOIN
                      dbo.Profile ON dbo.Department.ID = dbo.Profile.DepartmentID INNER JOIN
                      dbo.Complaint ON dbo.Profile.ID = dbo.Complaint.ProfileID INNER JOIN
                      dbo.Category ON dbo.Complaint.CategoryID = dbo.Category.ID INNER JOIN
                      dbo.Technician ON dbo.Complaint.TechnicianID = dbo.Technician.ID
GO
EXEC sys.sp_addextendedproperty @name=N'MS_DiagramPane1', @value=N'[0E232FF0-B466-11cf-A24F-00AA00A3EFFF, 1.00]
Begin DesignProperties = 
   Begin PaneConfigurations = 
      Begin PaneConfiguration = 0
         NumPanes = 4
         Configuration = "(H (1[40] 4[20] 2[20] 3) )"
      End
      Begin PaneConfiguration = 1
         NumPanes = 3
         Configuration = "(H (1 [50] 4 [25] 3))"
      End
      Begin PaneConfiguration = 2
         NumPanes = 3
         Configuration = "(H (1 [50] 2 [25] 3))"
      End
      Begin PaneConfiguration = 3
         NumPanes = 3
         Configuration = "(H (4 [30] 2 [40] 3))"
      End
      Begin PaneConfiguration = 4
         NumPanes = 2
         Configuration = "(H (1 [56] 3))"
      End
      Begin PaneConfiguration = 5
         NumPanes = 2
         Configuration = "(H (2 [66] 3))"
      End
      Begin PaneConfiguration = 6
         NumPanes = 2
         Configuration = "(H (4 [50] 3))"
      End
      Begin PaneConfiguration = 7
         NumPanes = 1
         Configuration = "(V (3))"
      End
      Begin PaneConfiguration = 8
         NumPanes = 3
         Configuration = "(H (1[56] 4[18] 2) )"
      End
      Begin PaneConfiguration = 9
         NumPanes = 2
         Configuration = "(H (1 [75] 4))"
      End
      Begin PaneConfiguration = 10
         NumPanes = 2
         Configuration = "(H (1[66] 2) )"
      End
      Begin PaneConfiguration = 11
         NumPanes = 2
         Configuration = "(H (4 [60] 2))"
      End
      Begin PaneConfiguration = 12
         NumPanes = 1
         Configuration = "(H (1) )"
      End
      Begin PaneConfiguration = 13
         NumPanes = 1
         Configuration = "(V (4))"
      End
      Begin PaneConfiguration = 14
         NumPanes = 1
         Configuration = "(V (2))"
      End
      ActivePaneConfig = 0
   End
   Begin DiagramPane = 
      Begin Origin = 
         Top = 0
         Left = 0
      End
      Begin Tables = 
         Begin Table = "Department"
            Begin Extent = 
               Top = 6
               Left = 38
               Bottom = 110
               Right = 198
            End
            DisplayFlags = 280
            TopColumn = 0
         End
         Begin Table = "Profile"
            Begin Extent = 
               Top = 6
               Left = 236
               Bottom = 125
               Right = 396
            End
            DisplayFlags = 280
            TopColumn = 0
         End
         Begin Table = "Complaint"
            Begin Extent = 
               Top = 6
               Left = 434
               Bottom = 125
               Right = 597
            End
            DisplayFlags = 280
            TopColumn = 6
         End
         Begin Table = "Category"
            Begin Extent = 
               Top = 6
               Left = 635
               Bottom = 110
               Right = 795
            End
            DisplayFlags = 280
            TopColumn = 0
         End
         Begin Table = "Technician"
            Begin Extent = 
               Top = 114
               Left = 38
               Bottom = 233
               Right = 198
            End
            DisplayFlags = 280
            TopColumn = 0
         End
      End
   End
   Begin SQLPane = 
   End
   Begin DataPane = 
      Begin ParameterDefaults = ""
      End
   End
   Begin CriteriaPane = 
      Begin ColumnWidths = 11
         Column = 1440
         Alias = 900
         Table = 1170
         Output = 720
         Append = 1400
         NewValue = 1170
         SortType = 1350
         SortOrder = 1410
         GroupBy = 1350
         Filter = 1350
         Or = 1350
         Or = 1350
         Or ' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'VIEW',@level1name=N'RDepartment'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_DiagramPane2', @value=N'= 1350
      End
   End
End
' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'VIEW',@level1name=N'RDepartment'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_DiagramPaneCount', @value=2 , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'VIEW',@level1name=N'RDepartment'
GO
/****** Object:  View [dbo].[RCategory]    Script Date: 10/08/2012 14:35:34 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE VIEW [dbo].[RCategory]
AS
SELECT     dbo.Category.Name AS Category, dbo.Complaint.CreatedDate, dbo.Complaint.CompletedDate, dbo.Complaint.Note, dbo.Profile.FullName, dbo.Technician.Name AS Technician
FROM         dbo.Category INNER JOIN
                      dbo.Complaint ON dbo.Category.ID = dbo.Complaint.CategoryID INNER JOIN
                      dbo.Profile ON dbo.Complaint.ProfileID = dbo.Profile.ID INNER JOIN
                      dbo.Technician ON dbo.Complaint.TechnicianID = dbo.Technician.ID
GO
EXEC sys.sp_addextendedproperty @name=N'MS_DiagramPane1', @value=N'[0E232FF0-B466-11cf-A24F-00AA00A3EFFF, 1.00]
Begin DesignProperties = 
   Begin PaneConfigurations = 
      Begin PaneConfiguration = 0
         NumPanes = 4
         Configuration = "(H (1[40] 4[20] 2[20] 3) )"
      End
      Begin PaneConfiguration = 1
         NumPanes = 3
         Configuration = "(H (1 [50] 4 [25] 3))"
      End
      Begin PaneConfiguration = 2
         NumPanes = 3
         Configuration = "(H (1 [50] 2 [25] 3))"
      End
      Begin PaneConfiguration = 3
         NumPanes = 3
         Configuration = "(H (4 [30] 2 [40] 3))"
      End
      Begin PaneConfiguration = 4
         NumPanes = 2
         Configuration = "(H (1 [56] 3))"
      End
      Begin PaneConfiguration = 5
         NumPanes = 2
         Configuration = "(H (2 [66] 3))"
      End
      Begin PaneConfiguration = 6
         NumPanes = 2
         Configuration = "(H (4 [50] 3))"
      End
      Begin PaneConfiguration = 7
         NumPanes = 1
         Configuration = "(V (3))"
      End
      Begin PaneConfiguration = 8
         NumPanes = 3
         Configuration = "(H (1[56] 4[18] 2) )"
      End
      Begin PaneConfiguration = 9
         NumPanes = 2
         Configuration = "(H (1 [75] 4))"
      End
      Begin PaneConfiguration = 10
         NumPanes = 2
         Configuration = "(H (1[66] 2) )"
      End
      Begin PaneConfiguration = 11
         NumPanes = 2
         Configuration = "(H (4 [60] 2))"
      End
      Begin PaneConfiguration = 12
         NumPanes = 1
         Configuration = "(H (1) )"
      End
      Begin PaneConfiguration = 13
         NumPanes = 1
         Configuration = "(V (4))"
      End
      Begin PaneConfiguration = 14
         NumPanes = 1
         Configuration = "(V (2))"
      End
      ActivePaneConfig = 0
   End
   Begin DiagramPane = 
      Begin Origin = 
         Top = 0
         Left = 0
      End
      Begin Tables = 
         Begin Table = "Category"
            Begin Extent = 
               Top = 6
               Left = 38
               Bottom = 110
               Right = 198
            End
            DisplayFlags = 280
            TopColumn = 0
         End
         Begin Table = "Complaint"
            Begin Extent = 
               Top = 6
               Left = 236
               Bottom = 125
               Right = 399
            End
            DisplayFlags = 280
            TopColumn = 6
         End
         Begin Table = "Profile"
            Begin Extent = 
               Top = 6
               Left = 437
               Bottom = 125
               Right = 597
            End
            DisplayFlags = 280
            TopColumn = 3
         End
         Begin Table = "Technician"
            Begin Extent = 
               Top = 6
               Left = 635
               Bottom = 125
               Right = 795
            End
            DisplayFlags = 280
            TopColumn = 1
         End
      End
   End
   Begin SQLPane = 
   End
   Begin DataPane = 
      Begin ParameterDefaults = ""
      End
   End
   Begin CriteriaPane = 
      Begin ColumnWidths = 11
         Column = 1440
         Alias = 900
         Table = 1170
         Output = 720
         Append = 1400
         NewValue = 1170
         SortType = 1350
         SortOrder = 1410
         GroupBy = 1350
         Filter = 1350
         Or = 1350
         Or = 1350
         Or = 1350
      End
   End
End
' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'VIEW',@level1name=N'RCategory'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_DiagramPaneCount', @value=1 , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'VIEW',@level1name=N'RCategory'
GO
/****** Object:  ForeignKey [FK_Account_Profile]    Script Date: 10/08/2012 14:35:33 ******/
ALTER TABLE [dbo].[Account]  WITH CHECK ADD  CONSTRAINT [FK_Account_Profile] FOREIGN KEY([ProfileID])
REFERENCES [dbo].[Profile] ([ID])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[Account] CHECK CONSTRAINT [FK_Account_Profile]
GO
/****** Object:  ForeignKey [FK_Account_Role]    Script Date: 10/08/2012 14:35:33 ******/
ALTER TABLE [dbo].[Account]  WITH CHECK ADD  CONSTRAINT [FK_Account_Role] FOREIGN KEY([RoleID])
REFERENCES [dbo].[Role] ([ID])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[Account] CHECK CONSTRAINT [FK_Account_Role]
GO
/****** Object:  ForeignKey [FK_Complaint_Category]    Script Date: 10/08/2012 14:35:33 ******/
ALTER TABLE [dbo].[Complaint]  WITH CHECK ADD  CONSTRAINT [FK_Complaint_Category] FOREIGN KEY([CategoryID])
REFERENCES [dbo].[Category] ([ID])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[Complaint] CHECK CONSTRAINT [FK_Complaint_Category]
GO
/****** Object:  ForeignKey [FK_Complaint_Profile]    Script Date: 10/08/2012 14:35:33 ******/
ALTER TABLE [dbo].[Complaint]  WITH CHECK ADD  CONSTRAINT [FK_Complaint_Profile] FOREIGN KEY([ProfileID])
REFERENCES [dbo].[Profile] ([ID])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[Complaint] CHECK CONSTRAINT [FK_Complaint_Profile]
GO
/****** Object:  ForeignKey [FK_Complaint_Technician]    Script Date: 10/08/2012 14:35:33 ******/
ALTER TABLE [dbo].[Complaint]  WITH CHECK ADD  CONSTRAINT [FK_Complaint_Technician] FOREIGN KEY([TechnicianID])
REFERENCES [dbo].[Technician] ([ID])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[Complaint] CHECK CONSTRAINT [FK_Complaint_Technician]
GO
/****** Object:  ForeignKey [FK_Profile_Department]    Script Date: 10/08/2012 14:35:33 ******/
ALTER TABLE [dbo].[Profile]  WITH CHECK ADD  CONSTRAINT [FK_Profile_Department] FOREIGN KEY([DepartmentID])
REFERENCES [dbo].[Department] ([ID])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[Profile] CHECK CONSTRAINT [FK_Profile_Department]
GO
