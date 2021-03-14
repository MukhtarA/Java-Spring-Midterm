import {useCallback, useEffect, useState} from 'react';
import './App.css';
import axios from "axios";
import {useDropzone} from "react-dropzone";

const UsersProfile = () => {

    const [userProfiles, setUserProfiles] = useState([]);
    const fetchUser = () => {
        axios.get("http://localhost:8080/user-profile").then(r => {
            console.log(r);
            setUserProfiles(r.data);
        });
    }

    useEffect(() => {
        fetchUser();
    }, [])

    return userProfiles.map((userProfile, index) => {
        return (
            <div style={{
                border: '3px solid pink',
                margin: 150,
            }}
                 key={index}
            >
                {userProfile ? <img style={{width: 600, marginTop: 20}} src={`http://localhost:8080/user-profile/${userProfile.userProfileId}/image/download`}/> : null }
                <h3>Full name: {userProfile.username}</h3>
                <p>Position: {userProfile.position}</p>
                <MyDropzone {...userProfile}/>
            </div>
        )
    })
}


function MyDropzone({userProfileId}) {
    const onDrop = useCallback(acceptedFiles => {
        const file = acceptedFiles[0];
        const formData = new FormData();
        formData.append("file", file);

        axios.post(`http://localhost:8080/user-profile/${userProfileId}/image/upload`,
            formData,
            {
                headers: {
                    "Content-Type": "multipart/form-data"
                }
            }
        ).then(() => {
            console.log("succeeded");
        }).catch(err => {
            console.log(err);
        });

    }, [])
    const {getRootProps, getInputProps, isDragActive} = useDropzone({onDrop})

    return (
        <div {...getRootProps()}>
            <input {...getInputProps()} />
            {
                isDragActive ?
                    <p>Drop the files here ...</p> :
                    <p>Drag 'n' drop some files here, or click to select files</p>
            }
        </div>
    )
}

function App() {
    return (
        <div className="App">
            <UsersProfile/>
        </div>
    );
}

export default App;
