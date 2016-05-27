Imports MySql.Data.MySqlClient

Public Class CadUsuario
    Private Sub Button1_Click(sender As Object, e As EventArgs) Handles Button1.Click

        If txtNome.Text = "" Then
            MsgBox("Favor, preencher o campo nome.", MsgBoxStyle.Information)
        ElseIf txtEmail.Text = "" Then
            MsgBox("Favor, preencher o campos e-mail.", MsgBoxStyle.Information)
        ElseIf txtSenha.Text = "" Then
            MsgBox("Favor, preencher o campo senha.", MsgBoxStyle.Information)
        Else
            objconn = New MySqlConnection
            objconn.ConnectionString = "server='localhost';user='root';password='MySQL';database='agendamento';"
            objconn.Open()

            Dim nome As String = txtNome.Text
            Dim telefone As String = txtTelefone.Text
            Dim cpf As String = txtCpf.Text
            Dim email As String = txtEmail.Text
            Dim senha As String = txtSenha.Text
            Dim tipo_usuario As String = cbTipoUsuario.Text

            Dim tp_user As Integer
            If (tipo_usuario = "Aluno") = True Then
                tp_user = 0
            ElseIf (tipo_usuario = "Funcionário") = True Then
                tp_user = 1
            End If

            Try
                objcmd = New MySql.Data.MySqlClient.MySqlCommand("INSERT INTO usuario (nm_usuario,tel_usuario,cpf_usuario,email_usuario,senha_usuario,tipo_usuario) VALUES (@field1,@field2,@field3,@field4,@field5,@field6)", objconn)
                With objcmd
                    .Parameters.AddWithValue("@field1", nome)
                    .Parameters.AddWithValue("@field2", telefone)
                    .Parameters.AddWithValue("@field3", cpf)
                    .Parameters.AddWithValue("@field4", email)
                    .Parameters.AddWithValue("@field5", senha)
                    .Parameters.AddWithValue("@field6", tp_user)
                End With
                objcmd.ExecuteNonQuery()
                objcmd.Dispose()
                MsgBox("Cadastro efetuado com sucesso!", MsgBoxStyle.Information)
                limparCampos()
            Catch ex As Exception
                MsgBox("Erro")
            End Try
        End If
    End Sub

    Public Sub limparCampos()
        txtNome.Text = ""
        txtTelefone.Text = ""
        txtCpf.Text = ""
        txtEmail.Text = ""
        txtSenha.Text = ""
        cbTipoUsuario.Text = "Aluno"
    End Sub

    Private Sub Button2_Click(sender As Object, e As EventArgs) Handles Button2.Click
        limparCampos()
    End Sub

    Private Sub CadastroDeHorárioToolStripMenuItem_Click(sender As Object, e As EventArgs) Handles CadastroDeHorárioToolStripMenuItem.Click
        Login.Show()
        Me.Hide()
    End Sub

    Private Sub SairToolStripMenuItem_Click(sender As Object, e As EventArgs) Handles SairToolStripMenuItem.Click
        Application.Exit()
    End Sub
End Class
