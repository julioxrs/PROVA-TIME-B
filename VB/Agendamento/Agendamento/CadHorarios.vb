Imports MySql.Data.MySqlClient
Public Class CadHorarios

    Dim id_user As String = ""
    Public Sub New(ByVal valor As String)
        InitializeComponent()
        'Atribui ao txtValorRecebido o valor enviado por Parâmetro
        id_user = valor
    End Sub

    Private Sub Button1_Click(sender As Object, e As EventArgs) Handles Button1.Click

        objconn = New MySqlConnection
        objconn.ConnectionString = "server='localhost';user='root';password='MySQL';database='agendamento';"
        objconn.Open()

        Dim hora As String = txtHora.Text
        Dim data As String = dtpData.Value.ToString("yyyy-MM-dd")

        Try
            objcmd = New MySql.Data.MySqlClient.MySqlCommand("INSERT INTO horario (hora_horario,data_horario) VALUES (@field1,@field2)", objconn)
            With objcmd
                .Parameters.AddWithValue("@field1", hora)
                .Parameters.AddWithValue("@field2", data)
            End With
            objcmd.ExecuteNonQuery()
            objcmd.Dispose()
            MsgBox("Cadastro efetuado com sucesso!", MsgBoxStyle.Information)
            'limparCampos()
        Catch ex As Exception
            MsgBox("Erro")
        End Try


    End Sub

End Class