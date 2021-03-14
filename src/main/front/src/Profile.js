const Profile = ({name, position, ...rest}) => {
    return (
        <>
            <h2>{name}</h2>
            <p>{position}</p>
        </>
    )
}

export default Profile;