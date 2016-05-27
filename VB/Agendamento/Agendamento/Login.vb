Imports MySql.Data.MySqlClient

Public Class Login
    Private Sub Button1_Click(sender As Object, e As EventArgs) Handles Button1.Click
        If txtloginEmail.Text = "" Then
            MsgBox("Favor preencher com o E-mail.", MsgBoxStyle.Information)
        ElseIf txtLoginSenha.Text = "" Then
            MsgBox("Favor preencher com a senha.", MsgBoxStyle.Information)
        Else
            Dim connString As String = "server='localhost';user='root';password='MySQL';database='agendamento';"
            Dim sqlQuery As String = "SELECT * FROM usuario WHERE email_usuario = @email and senha_usuario = @senha and tipo_usuario = 1"
            Using sqlConn As New MySqlConnection(connString)
                Using sqlComm As New MySqlCommand()
                    With sqlComm
                        .Connection = sqlConn
                        .CommandText = sqlQuery
                        .CommandType = CommandType.Text
                        .Parameters.AddWithValue("@email", txtloginEmail.Text)
                        .Parameters.AddWithValue("@senha", txtLoginSenha.Text)
                    End With
                    Try
                        sqlConn.Open()
                        Dim sqlReader As MySqlDataReader = sqlComm.ExecuteReader()
                        If sqlReader.Read() Then

                            Dim idUsuario As String = sqlReader("id_usuario").ToString()
                            Dim cadHorarios As New CadHorarios(idUsuario)
                            cadHorarios.ShowDialog()
                            Me.Hide()
                        Else
                            MsgBox("Usuário ou senha incorretos.")
                        End If


                    Catch ex As MySqlException

                    End Try
                End Using
            End Using
        End If
    End Sub

    Private Sub Button2_Click(sender As Object, e As EventArgs) Handles Button2.Click
        txtloginEmail.Text = ""
        txtLoginSenha.Text = ""
    End Sub
End Class