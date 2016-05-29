<Global.Microsoft.VisualBasic.CompilerServices.DesignerGenerated()> _
Partial Class CadHorarios
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
        Dim resources As System.ComponentModel.ComponentResourceManager = New System.ComponentModel.ComponentResourceManager(GetType(CadHorarios))
        Me.Label2 = New System.Windows.Forms.Label()
        Me.Label1 = New System.Windows.Forms.Label()
        Me.txtHora = New System.Windows.Forms.MaskedTextBox()
        Me.Button1 = New System.Windows.Forms.Button()
        Me.dtpData = New System.Windows.Forms.DateTimePicker()
        Me.PictureBox1 = New System.Windows.Forms.PictureBox()
        Me.Button2 = New System.Windows.Forms.Button()
        Me.Button3 = New System.Windows.Forms.Button()
        Me.DataGridView1 = New System.Windows.Forms.DataGridView()
        Me.id_horario = New System.Windows.Forms.DataGridViewTextBoxColumn()
        Me.hora = New System.Windows.Forms.DataGridViewTextBoxColumn()
        Me.data = New System.Windows.Forms.DataGridViewTextBoxColumn()
        Me.disponivel = New System.Windows.Forms.DataGridViewTextBoxColumn()
        CType(Me.PictureBox1, System.ComponentModel.ISupportInitialize).BeginInit()
        CType(Me.DataGridView1, System.ComponentModel.ISupportInitialize).BeginInit()
        Me.SuspendLayout()
        '
        'Label2
        '
        Me.Label2.AutoSize = True
        Me.Label2.Location = New System.Drawing.Point(32, 72)
        Me.Label2.Name = "Label2"
        Me.Label2.Size = New System.Drawing.Size(48, 20)
        Me.Label2.TabIndex = 40
        Me.Label2.Text = "Data:"
        '
        'Label1
        '
        Me.Label1.AutoSize = True
        Me.Label1.Location = New System.Drawing.Point(32, 33)
        Me.Label1.Name = "Label1"
        Me.Label1.Size = New System.Drawing.Size(48, 20)
        Me.Label1.TabIndex = 39
        Me.Label1.Text = "Hora:"
        '
        'txtHora
        '
        Me.txtHora.Location = New System.Drawing.Point(86, 30)
        Me.txtHora.Mask = "90:00:00"
        Me.txtHora.Name = "txtHora"
        Me.txtHora.Size = New System.Drawing.Size(100, 26)
        Me.txtHora.TabIndex = 38
        '
        'Button1
        '
        Me.Button1.Location = New System.Drawing.Point(36, 115)
        Me.Button1.Name = "Button1"
        Me.Button1.Size = New System.Drawing.Size(162, 57)
        Me.Button1.TabIndex = 37
        Me.Button1.Text = "Cadastrar Horário"
        Me.Button1.UseVisualStyleBackColor = True
        '
        'dtpData
        '
        Me.dtpData.Location = New System.Drawing.Point(86, 67)
        Me.dtpData.Name = "dtpData"
        Me.dtpData.Size = New System.Drawing.Size(336, 26)
        Me.dtpData.TabIndex = 36
        '
        'PictureBox1
        '
        Me.PictureBox1.Image = CType(resources.GetObject("PictureBox1.Image"), System.Drawing.Image)
        Me.PictureBox1.Location = New System.Drawing.Point(446, 30)
        Me.PictureBox1.Name = "PictureBox1"
        Me.PictureBox1.Size = New System.Drawing.Size(409, 242)
        Me.PictureBox1.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage
        Me.PictureBox1.TabIndex = 41
        Me.PictureBox1.TabStop = False
        '
        'Button2
        '
        Me.Button2.Location = New System.Drawing.Point(220, 115)
        Me.Button2.Name = "Button2"
        Me.Button2.Size = New System.Drawing.Size(162, 57)
        Me.Button2.TabIndex = 42
        Me.Button2.Text = "Limpar Campos"
        Me.Button2.UseVisualStyleBackColor = True
        '
        'Button3
        '
        Me.Button3.Location = New System.Drawing.Point(36, 188)
        Me.Button3.Name = "Button3"
        Me.Button3.Size = New System.Drawing.Size(162, 57)
        Me.Button3.TabIndex = 43
        Me.Button3.Text = "Sair"
        Me.Button3.UseVisualStyleBackColor = True
        '
        'DataGridView1
        '
        Me.DataGridView1.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize
        Me.DataGridView1.Columns.AddRange(New System.Windows.Forms.DataGridViewColumn() {Me.id_horario, Me.hora, Me.data, Me.disponivel})
        Me.DataGridView1.Location = New System.Drawing.Point(26, 318)
        Me.DataGridView1.Name = "DataGridView1"
        Me.DataGridView1.RowTemplate.Height = 28
        Me.DataGridView1.Size = New System.Drawing.Size(829, 231)
        Me.DataGridView1.TabIndex = 44
        '
        'id_horario
        '
        Me.id_horario.DataPropertyName = "id_horario"
        Me.id_horario.HeaderText = "ID Horário"
        Me.id_horario.Name = "id_horario"
        '
        'hora
        '
        Me.hora.DataPropertyName = "hora_horario"
        Me.hora.HeaderText = "Horário"
        Me.hora.Name = "hora"
        '
        'data
        '
        Me.data.DataPropertyName = "data_horario"
        Me.data.HeaderText = "Data"
        Me.data.Name = "data"
        '
        'disponivel
        '
        Me.disponivel.DataPropertyName = "disp_horario"
        Me.disponivel.HeaderText = "Disponível"
        Me.disponivel.Name = "disponivel"
        '
        'CadHorarios
        '
        Me.AutoScaleDimensions = New System.Drawing.SizeF(9.0!, 20.0!)
        Me.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font
        Me.ClientSize = New System.Drawing.Size(887, 571)
        Me.Controls.Add(Me.DataGridView1)
        Me.Controls.Add(Me.Button3)
        Me.Controls.Add(Me.Button2)
        Me.Controls.Add(Me.PictureBox1)
        Me.Controls.Add(Me.Label2)
        Me.Controls.Add(Me.Label1)
        Me.Controls.Add(Me.txtHora)
        Me.Controls.Add(Me.Button1)
        Me.Controls.Add(Me.dtpData)
        Me.MaximizeBox = False
        Me.Name = "CadHorarios"
        Me.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen
        Me.Text = "Cadastro de Horários"
        CType(Me.PictureBox1, System.ComponentModel.ISupportInitialize).EndInit()
        CType(Me.DataGridView1, System.ComponentModel.ISupportInitialize).EndInit()
        Me.ResumeLayout(False)
        Me.PerformLayout()

    End Sub

    Friend WithEvents Label2 As Label
    Friend WithEvents Label1 As Label
    Friend WithEvents txtHora As MaskedTextBox
    Friend WithEvents Button1 As Button
    Friend WithEvents dtpData As DateTimePicker
    Friend WithEvents PictureBox1 As PictureBox
    Friend WithEvents Button2 As Button
    Friend WithEvents Button3 As Button
    Friend WithEvents DataGridView1 As DataGridView
    Friend WithEvents id_horario As DataGridViewTextBoxColumn
    Friend WithEvents hora As DataGridViewTextBoxColumn
    Friend WithEvents data As DataGridViewTextBoxColumn
    Friend WithEvents disponivel As DataGridViewTextBoxColumn
End Class
