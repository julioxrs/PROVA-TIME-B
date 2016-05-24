Imports MySql.Data.MySqlClient

Public Class CadUsuario
    Private Sub Button1_Click(sender As Object, e As EventArgs) Handles Button1.Click
        objconn = New MySqlConnection
        objconn.ConnectionString = "server='localhost';user='root';password='MySQL';database='agendamento';"
        objconn.Open()

        Dim nome As String = txtNome.Text
        Dim telefone As String = txtTelefone.Text
        Dim cpf As String = txtCpf.Text
        Dim email As String = txtEmail.Text
        Dim senha As String = txtSenha.Text
        Try
            objcmd = New MySql.Data.MySqlClient.MySqlCommand("INSERT INTO usuario (nm_usuario,tel_usuario,cpf_usuario,email_usuario,senha_usuario) VALUES (@field1,@field2,@field3,@field4,@field5)", objconn)
            With objcmd
                .Parameters.AddWithValue("@field1", nome)
                .Parameters.AddWithValue("@field2", telefone)
                .Parameters.AddWithValue("@field3", cpf)
                .Parameters.AddWithValue("@field4", email)
                .Parameters.AddWithValue("@field5", senha)
            End With
            objcmd.ExecuteNonQuery()
            objcmd.Dispose()
            MsgBox("Cadastro efetuado com sucesso!", MsgBoxStyle.Information)
        Catch ex As Exception
            MsgBox("Erro")
        End Try
    End Sub
End Class
