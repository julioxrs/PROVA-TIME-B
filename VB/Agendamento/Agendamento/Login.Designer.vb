<Global.Microsoft.VisualBasic.CompilerServices.DesignerGenerated()> _
Partial Class Login
    Inherits System.Windows.Forms.Form

    'Form overrides dispose to clean up the component list.
    <System.Diagnostics.DebuggerNonUserCode()> _
    Protected Overrides Sub Dispose(ByVal disposing As Boolean)
        Try
            If disposing AndAlso components IsNot Nothing Then
                components.Dispose()
            End If
        Finally
            MyBase.Dispose(disposing)
        End Try
    End Sub

    'Required by the Windows Form Designer
    Private components As System.ComponentModel.IContainer

    'NOTE: The following procedure is required by the Windows Form Designer
    'It can be modified using the Windows Form Designer.  
    'Do not modify it using the code editor.
    <System.Diagnostics.DebuggerStepThrough()> _
    Private Sub InitializeComponent()
        Dim resources As System.ComponentModel.ComponentResourceManager = New System.ComponentModel.ComponentResourceManager(GetType(Login))
        Me.Button2 = New System.Windows.Forms.Button()
        Me.Button1 = New System.Windows.Forms.Button()
        Me.txtLoginSenha = New System.Windows.Forms.TextBox()
        Me.Label1 = New System.Windows.Forms.Label()
        Me.txtloginEmail = New System.Windows.Forms.TextBox()
        Me.txtEmail = New System.Windows.Forms.Label()
        Me.PictureBox1 = New System.Windows.Forms.PictureBox()
        CType(Me.PictureBox1, System.ComponentModel.ISupportInitialize).BeginInit()
        Me.SuspendLayout()
        '
        'Button2
        '
        Me.Button2.Location = New System.Drawing.Point(181, 150)
        Me.Button2.Name = "Button2"
        Me.Button2.Size = New System.Drawing.Size(183, 49)
        Me.Button2.TabIndex = 11
        Me.Button2.Text = "Limpar Campos"
        Me.Button2.UseVisualStyleBackColor = True
        '
        'Button1
        '
        Me.Button1.Location = New System.Drawing.Point(37, 150)
        Me.Button1.Name = "Button1"
        Me.Button1.Size = New System.Drawing.Size(121, 49)
        Me.Button1.TabIndex = 10
        Me.Button1.Text = "Logar"
        Me.Button1.UseVisualStyleBackColor = True
        '
        'txtLoginSenha
        '
        Me.txtLoginSenha.Location = New System.Drawing.Point(110, 89)
        Me.txtLoginSenha.Name = "txtLoginSenha"
        Me.txtLoginSenha.PasswordChar = Global.Microsoft.VisualBasic.ChrW(42)
        Me.txtLoginSenha.Size = New System.Drawing.Size(316, 26)
        Me.txtLoginSenha.TabIndex = 9
        '
        'Label1
        '
        Me.Label1.AutoSize = True
        Me.Label1.Location = New System.Drawing.Point(33, 89)
        Me.Label1.Name = "Label1"
        Me.Label1.Size = New System.Drawing.Size(60, 20)
        Me.Label1.TabIndex = 8
        Me.Label1.Text = "Senha:"
        '
        'txtloginEmail
        '
        Me.txtloginEmail.Location = New System.Drawing.Point(110, 40)
        Me.txtloginEmail.Name = "txtloginEmail"
        Me.txtloginEmail.Size = New System.Drawing.Size(316, 26)
        Me.txtloginEmail.TabIndex = 7
        '
        'txtEmail
        '
        Me.txtEmail.AutoSize = True
        Me.txtEmail.Location = New System.Drawing.Point(33, 43)
        Me.txtEmail.Name = "txtEmail"
        Me.txtEmail.Size = New System.Drawing.Size(57, 20)
        Me.txtEmail.TabIndex = 6
        Me.txtEmail.Text = "E-mail:"
        '
        'PictureBox1
        '
        Me.PictureBox1.Image = CType(resources.GetObject("PictureBox1.Image"), System.Drawing.Image)
        Me.PictureBox1.Location = New System.Drawing.Point(450, 40)
        Me.PictureBox1.Name = "PictureBox1"
        Me.PictureBox1.Size = New System.Drawing.Size(262, 147)
        Me.PictureBox1.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage
        Me.PictureBox1.TabIndex = 27
        Me.PictureBox1.TabStop = False
        '
        'Login
        '
        Me.AutoScaleDimensions = New System.Drawing.SizeF(9.0!, 20.0!)
        Me.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font
        Me.ClientSize = New System.Drawing.Size(748, 245)
        Me.Controls.Add(Me.PictureBox1)
        Me.Controls.Add(Me.Button2)
        Me.Controls.Add(Me.Button1)
        Me.Controls.Add(Me.txtLoginSenha)
        Me.Controls.Add(Me.Label1)
        Me.Controls.Add(Me.txtloginEmail)
        Me.Controls.Add(Me.txtEmail)
        Me.MaximizeBox = False
        Me.Name = "Login"
        Me.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen
        Me.Text = "Login"
        CType(Me.PictureBox1, System.ComponentModel.ISupportInitialize).EndInit()
        Me.ResumeLayout(False)
        Me.PerformLayout()

    End Sub

    Friend WithEvents Button2 As Button
    Friend WithEvents Button1 As Button
    Friend WithEvents txtLoginSenha As TextBox
    Friend WithEvents Label1 As Label
    Friend WithEvents txtloginEmail As TextBox
    Friend WithEvents txtEmail As Label
    Friend WithEvents PictureBox1 As PictureBox
End Class
