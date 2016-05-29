<Global.Microsoft.VisualBasic.CompilerServices.DesignerGenerated()> _
Partial Class CadUsuario
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
        Dim resources As System.ComponentModel.ComponentResourceManager = New System.ComponentModel.ComponentResourceManager(GetType(CadUsuario))
        Me.Label5 = New System.Windows.Forms.Label()
        Me.Label4 = New System.Windows.Forms.Label()
        Me.txtEmail = New System.Windows.Forms.TextBox()
        Me.Label3 = New System.Windows.Forms.Label()
        Me.Label2 = New System.Windows.Forms.Label()
        Me.Label1 = New System.Windows.Forms.Label()
        Me.txtNome = New System.Windows.Forms.TextBox()
        Me.txtSenha = New System.Windows.Forms.TextBox()
        Me.Button1 = New System.Windows.Forms.Button()
        Me.txtTelefone = New System.Windows.Forms.MaskedTextBox()
        Me.txtCpf = New System.Windows.Forms.MaskedTextBox()
        Me.MenuStrip1 = New System.Windows.Forms.MenuStrip()
        Me.InícioToolStripMenuItem = New System.Windows.Forms.ToolStripMenuItem()
        Me.CadastroDeHorárioToolStripMenuItem = New System.Windows.Forms.ToolStripMenuItem()
        Me.SairToolStripMenuItem = New System.Windows.Forms.ToolStripMenuItem()
        Me.PictureBox1 = New System.Windows.Forms.PictureBox()
        Me.Label6 = New System.Windows.Forms.Label()
        Me.cbTipoUsuario = New System.Windows.Forms.ComboBox()
        Me.Button2 = New System.Windows.Forms.Button()
        Me.DataGridView1 = New System.Windows.Forms.DataGridView()
        Me.id_usuario = New System.Windows.Forms.DataGridViewTextBoxColumn()
        Me.nm_usuario = New System.Windows.Forms.DataGridViewTextBoxColumn()
        Me.telefone = New System.Windows.Forms.DataGridViewTextBoxColumn()
        Me.cpf = New System.Windows.Forms.DataGridViewTextBoxColumn()
        Me.email = New System.Windows.Forms.DataGridViewTextBoxColumn()
        Me.senha = New System.Windows.Forms.DataGridViewTextBoxColumn()
        Me.tipo = New System.Windows.Forms.DataGridViewTextBoxColumn()
        Me.avaliação = New System.Windows.Forms.DataGridViewTextBoxColumn()
        Me.Button3 = New System.Windows.Forms.Button()
        Me.Button4 = New System.Windows.Forms.Button()
        Me.MenuStrip1.SuspendLayout()
        CType(Me.PictureBox1, System.ComponentModel.ISupportInitialize).BeginInit()
        CType(Me.DataGridView1, System.ComponentModel.ISupportInitialize).BeginInit()
        Me.SuspendLayout()
        '
        'Label5
        '
        Me.Label5.AutoSize = True
        Me.Label5.Location = New System.Drawing.Point(27, 228)
        Me.Label5.Name = "Label5"
        Me.Label5.Size = New System.Drawing.Size(60, 20)
        Me.Label5.TabIndex = 22
        Me.Label5.Text = "Senha:"
        '
        'Label4
        '
        Me.Label4.AutoSize = True
        Me.Label4.Location = New System.Drawing.Point(27, 185)
        Me.Label4.Name = "Label4"
        Me.Label4.Size = New System.Drawing.Size(57, 20)
        Me.Label4.TabIndex = 21
        Me.Label4.Text = "E-mail:"
        '
        'txtEmail
        '
        Me.txtEmail.Location = New System.Drawing.Point(108, 179)
        Me.txtEmail.Name = "txtEmail"
        Me.txtEmail.Size = New System.Drawing.Size(415, 26)
        Me.txtEmail.TabIndex = 20
        '
        'Label3
        '
        Me.Label3.AutoSize = True
        Me.Label3.Location = New System.Drawing.Point(27, 138)
        Me.Label3.Name = "Label3"
        Me.Label3.Size = New System.Drawing.Size(44, 20)
        Me.Label3.TabIndex = 19
        Me.Label3.Text = "CPF:"
        '
        'Label2
        '
        Me.Label2.AutoSize = True
        Me.Label2.Location = New System.Drawing.Point(27, 93)
        Me.Label2.Name = "Label2"
        Me.Label2.Size = New System.Drawing.Size(75, 20)
        Me.Label2.TabIndex = 17
        Me.Label2.Text = "Telefone:"
        '
        'Label1
        '
        Me.Label1.AutoSize = True
        Me.Label1.Location = New System.Drawing.Point(27, 50)
        Me.Label1.Name = "Label1"
        Me.Label1.Size = New System.Drawing.Size(55, 20)
        Me.Label1.TabIndex = 15
        Me.Label1.Text = "Nome:"
        '
        'txtNome
        '
        Me.txtNome.Location = New System.Drawing.Point(108, 47)
        Me.txtNome.Name = "txtNome"
        Me.txtNome.Size = New System.Drawing.Size(415, 26)
        Me.txtNome.TabIndex = 13
        '
        'txtSenha
        '
        Me.txtSenha.Location = New System.Drawing.Point(108, 222)
        Me.txtSenha.Name = "txtSenha"
        Me.txtSenha.PasswordChar = Global.Microsoft.VisualBasic.ChrW(42)
        Me.txtSenha.Size = New System.Drawing.Size(233, 26)
        Me.txtSenha.TabIndex = 14
        '
        'Button1
        '
        Me.Button1.Location = New System.Drawing.Point(31, 330)
        Me.Button1.Name = "Button1"
        Me.Button1.Size = New System.Drawing.Size(170, 59)
        Me.Button1.TabIndex = 12
        Me.Button1.Text = "Cadastrar"
        Me.Button1.UseVisualStyleBackColor = True
        '
        'txtTelefone
        '
        Me.txtTelefone.Location = New System.Drawing.Point(108, 90)
        Me.txtTelefone.Mask = "(00)00000-0000"
        Me.txtTelefone.Name = "txtTelefone"
        Me.txtTelefone.Size = New System.Drawing.Size(233, 26)
        Me.txtTelefone.TabIndex = 23
        '
        'txtCpf
        '
        Me.txtCpf.Location = New System.Drawing.Point(108, 135)
        Me.txtCpf.Mask = "000,000,000-00"
        Me.txtCpf.Name = "txtCpf"
        Me.txtCpf.Size = New System.Drawing.Size(233, 26)
        Me.txtCpf.TabIndex = 24
        '
        'MenuStrip1
        '
        Me.MenuStrip1.ImageScalingSize = New System.Drawing.Size(24, 24)
        Me.MenuStrip1.Items.AddRange(New System.Windows.Forms.ToolStripItem() {Me.InícioToolStripMenuItem})
        Me.MenuStrip1.Location = New System.Drawing.Point(0, 0)
        Me.MenuStrip1.Name = "MenuStrip1"
        Me.MenuStrip1.Size = New System.Drawing.Size(1222, 33)
        Me.MenuStrip1.TabIndex = 25
        Me.MenuStrip1.Text = "MenuStrip1"
        '
        'InícioToolStripMenuItem
        '
        Me.InícioToolStripMenuItem.DropDownItems.AddRange(New System.Windows.Forms.ToolStripItem() {Me.CadastroDeHorárioToolStripMenuItem, Me.SairToolStripMenuItem})
        Me.InícioToolStripMenuItem.Name = "InícioToolStripMenuItem"
        Me.InícioToolStripMenuItem.Size = New System.Drawing.Size(66, 29)
        Me.InícioToolStripMenuItem.Text = "Início"
        '
        'CadastroDeHorárioToolStripMenuItem
        '
        Me.CadastroDeHorárioToolStripMenuItem.Name = "CadastroDeHorárioToolStripMenuItem"
        Me.CadastroDeHorárioToolStripMenuItem.Size = New System.Drawing.Size(258, 30)
        Me.CadastroDeHorárioToolStripMenuItem.Text = "Cadastro de Horário"
        '
        'SairToolStripMenuItem
        '
        Me.SairToolStripMenuItem.Name = "SairToolStripMenuItem"
        Me.SairToolStripMenuItem.Size = New System.Drawing.Size(258, 30)
        Me.SairToolStripMenuItem.Text = "Sair"
        '
        'PictureBox1
        '
        Me.PictureBox1.Image = CType(resources.GetObject("PictureBox1.Image"), System.Drawing.Image)
        Me.PictureBox1.Location = New System.Drawing.Point(654, 47)
        Me.PictureBox1.Name = "PictureBox1"
        Me.PictureBox1.Size = New System.Drawing.Size(524, 270)
        Me.PictureBox1.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage
        Me.PictureBox1.TabIndex = 26
        Me.PictureBox1.TabStop = False
        '
        'Label6
        '
        Me.Label6.AutoSize = True
        Me.Label6.Location = New System.Drawing.Point(30, 271)
        Me.Label6.Name = "Label6"
        Me.Label6.Size = New System.Drawing.Size(102, 20)
        Me.Label6.TabIndex = 29
        Me.Label6.Text = "Tipo Usuário:"
        '
        'cbTipoUsuario
        '
        Me.cbTipoUsuario.FormattingEnabled = True
        Me.cbTipoUsuario.Items.AddRange(New Object() {"Aluno", "Funcionário"})
        Me.cbTipoUsuario.Location = New System.Drawing.Point(138, 263)
        Me.cbTipoUsuario.Name = "cbTipoUsuario"
        Me.cbTipoUsuario.Size = New System.Drawing.Size(203, 28)
        Me.cbTipoUsuario.TabIndex = 28
        Me.cbTipoUsuario.Text = "Aluno"
        '
        'Button2
        '
        Me.Button2.Location = New System.Drawing.Point(597, 330)
        Me.Button2.Name = "Button2"
        Me.Button2.Size = New System.Drawing.Size(256, 59)
        Me.Button2.TabIndex = 30
        Me.Button2.Text = "Limpar Campos"
        Me.Button2.UseVisualStyleBackColor = True
        '
        'DataGridView1
        '
        Me.DataGridView1.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize
        Me.DataGridView1.Columns.AddRange(New System.Windows.Forms.DataGridViewColumn() {Me.id_usuario, Me.nm_usuario, Me.telefone, Me.cpf, Me.email, Me.senha, Me.tipo, Me.avaliação})
        Me.DataGridView1.Location = New System.Drawing.Point(34, 415)
        Me.DataGridView1.Name = "DataGridView1"
        Me.DataGridView1.RowTemplate.Height = 28
        Me.DataGridView1.Size = New System.Drawing.Size(1144, 246)
        Me.DataGridView1.TabIndex = 31
        '
        'id_usuario
        '
        Me.id_usuario.DataPropertyName = "id_usuario"
        Me.id_usuario.HeaderText = "ID"
        Me.id_usuario.Name = "id_usuario"
        '
        'nm_usuario
        '
        Me.nm_usuario.DataPropertyName = "nm_usuario"
        Me.nm_usuario.HeaderText = "Nome"
        Me.nm_usuario.Name = "nm_usuario"
        '
        'telefone
        '
        Me.telefone.DataPropertyName = "tel_usuario"
        Me.telefone.HeaderText = "Telefone"
        Me.telefone.Name = "telefone"
        '
        'cpf
        '
        Me.cpf.DataPropertyName = "cpf_usuario"
        Me.cpf.HeaderText = "CPF"
        Me.cpf.Name = "cpf"
        '
        'email
        '
        Me.email.DataPropertyName = "email_usuario"
        Me.email.HeaderText = "E-mail"
        Me.email.Name = "email"
        '
        'senha
        '
        Me.senha.DataPropertyName = "senha_usuario"
        Me.senha.HeaderText = "Senha"
        Me.senha.Name = "senha"
        '
        'tipo
        '
        Me.tipo.DataPropertyName = "tipo_usuario"
        Me.tipo.HeaderText = "Tipo"
        Me.tipo.Name = "tipo"
        '
        'avaliação
        '
        Me.avaliação.DataPropertyName = "avaliou_ead_usuario"
        Me.avaliação.HeaderText = "Avaliação EAD"
        Me.avaliação.Name = "avaliação"
        '
        'Button3
        '
        Me.Button3.Location = New System.Drawing.Point(221, 330)
        Me.Button3.Name = "Button3"
        Me.Button3.Size = New System.Drawing.Size(170, 59)
        Me.Button3.TabIndex = 32
        Me.Button3.Text = "Editar"
        Me.Button3.UseVisualStyleBackColor = True
        '
        'Button4
        '
        Me.Button4.Location = New System.Drawing.Point(408, 330)
        Me.Button4.Name = "Button4"
        Me.Button4.Size = New System.Drawing.Size(170, 59)
        Me.Button4.TabIndex = 33
        Me.Button4.Text = "Remover"
        Me.Button4.UseVisualStyleBackColor = True
        '
        'CadUsuario
        '
        Me.AutoScaleDimensions = New System.Drawing.SizeF(9.0!, 20.0!)
        Me.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font
        Me.ClientSize = New System.Drawing.Size(1222, 681)
        Me.Controls.Add(Me.Button4)
        Me.Controls.Add(Me.Button3)
        Me.Controls.Add(Me.DataGridView1)
        Me.Controls.Add(Me.Button2)
        Me.Controls.Add(Me.Label6)
        Me.Controls.Add(Me.cbTipoUsuario)
        Me.Controls.Add(Me.PictureBox1)
        Me.Controls.Add(Me.txtCpf)
        Me.Controls.Add(Me.txtTelefone)
        Me.Controls.Add(Me.Label5)
        Me.Controls.Add(Me.Label4)
        Me.Controls.Add(Me.txtEmail)
        Me.Controls.Add(Me.Label3)
        Me.Controls.Add(Me.Label2)
        Me.Controls.Add(Me.Label1)
        Me.Controls.Add(Me.txtNome)
        Me.Controls.Add(Me.txtSenha)
        Me.Controls.Add(Me.Button1)
        Me.Controls.Add(Me.MenuStrip1)
        Me.MainMenuStrip = Me.MenuStrip1
        Me.MaximizeBox = False
        Me.Name = "CadUsuario"
        Me.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen
        Me.Text = "Cadastro de Usuário"
        Me.MenuStrip1.ResumeLayout(False)
        Me.MenuStrip1.PerformLayout()
        CType(Me.PictureBox1, System.ComponentModel.ISupportInitialize).EndInit()
        CType(Me.DataGridView1, System.ComponentModel.ISupportInitialize).EndInit()
        Me.ResumeLayout(False)
        Me.PerformLayout()

    End Sub

    Friend WithEvents Label5 As Label
    Friend WithEvents Label4 As Label
    Friend WithEvents txtEmail As TextBox
    Friend WithEvents Label3 As Label
    Friend WithEvents Label2 As Label
    Friend WithEvents Label1 As Label
    Friend WithEvents txtNome As TextBox
    Friend WithEvents txtSenha As TextBox
    Friend WithEvents Button1 As Button
    Friend WithEvents txtTelefone As MaskedTextBox
    Friend WithEvents txtCpf As MaskedTextBox
    Friend WithEvents MenuStrip1 As MenuStrip
    Friend WithEvents InícioToolStripMenuItem As ToolStripMenuItem
    Friend WithEvents CadastroDeHorárioToolStripMenuItem As ToolStripMenuItem
    Friend WithEvents PictureBox1 As PictureBox
    Friend WithEvents Label6 As Label
    Friend WithEvents cbTipoUsuario As ComboBox
    Friend WithEvents Button2 As Button
    Friend WithEvents SairToolStripMenuItem As ToolStripMenuItem
    Friend WithEvents DataGridView1 As DataGridView
    Friend WithEvents id_usuario As DataGridViewTextBoxColumn
    Friend WithEvents nm_usuario As DataGridViewTextBoxColumn
    Friend WithEvents telefone As DataGridViewTextBoxColumn
    Friend WithEvents cpf As DataGridViewTextBoxColumn
    Friend WithEvents email As DataGridViewTextBoxColumn
    Friend WithEvents senha As DataGridViewTextBoxColumn
    Friend WithEvents tipo As DataGridViewTextBoxColumn
    Friend WithEvents avaliação As DataGridViewTextBoxColumn
    Friend WithEvents Button3 As Button
    Friend WithEvents Button4 As Button
End Class
